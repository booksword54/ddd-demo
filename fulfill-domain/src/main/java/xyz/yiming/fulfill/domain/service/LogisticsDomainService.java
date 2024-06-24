package xyz.yiming.fulfill.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.domain.gateway.LogisticsApiGateway;
import xyz.yiming.fulfill.domain.model.logistics.LogisticsCompanies;
import xyz.yiming.fulfill.domain.model.logistics.LogisticsCompany;
import xyz.yiming.fulfill.domain.model.logistics.LogisticsOrder;
import xyz.yiming.fulfill.domain.model.warehouse.Warehouse;
import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;

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
        // 查询所有的物流公司
        LogisticsCompanies logisticsCompanies = logisticsApiGateway.getAll();
        // 选择仓库附近最合适的物流公司
        LogisticsCompany logisticsCompany = logisticsCompanies.selectBest(warehouse);
        // 向物流公司申请电子物流面单
        LogisticsOrder logisticsOrder = logisticsCompany.applyLogisticsOrder(fulfillOrder, warehouse);
        // 把电子物流面单分配给履约订单
        fulfillOrder.allocatedLogisticsOrder(logisticsOrder);
    }

}
