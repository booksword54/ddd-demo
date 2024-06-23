package xyz.yiming.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.gateway.LogisticsApiGateway;
import xyz.yiming.web.domain.logistics.LogisticsCompanies;
import xyz.yiming.web.domain.logistics.LogisticsCompany;
import xyz.yiming.web.domain.logistics.LogisticsOrder;
import xyz.yiming.web.domain.warehouse.Warehouse;

/**
 * 物流领域服务
 */
@Component
public class LogisticsDomainService {

    @Autowired
    private LogisticsApiGateway logisticsApiGateway;

    /**
     * 分物流
     */
    public void allocateLogistics(FulfillOrder fulfillOrder, Warehouse warehouse) {
        LogisticsCompanies logisticsCompanies = logisticsApiGateway.getAll();
        LogisticsCompany logisticsCompany = logisticsCompanies.selectBest(warehouse);
        // 申请电子面单
        LogisticsOrder logisticsOrder = logisticsCompany.applyLogisticsOrder(fulfillOrder, warehouse);
        // 分配物流单
        fulfillOrder.allocatedLogisticsOrder(logisticsOrder);
    }

}
