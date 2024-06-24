package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.infrastructure.converter.FulfillOrderDOConverter;
import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.FulfillOrderGateway;
import xyz.yiming.fulfill.domain.model.logistics.LogisticsOrder;
import xyz.yiming.fulfill.domain.model.warehouse.Warehouse;
import xyz.yiming.fulfill.infrastructure.gatewayimpl.database.FulfillOrderMapper;
import xyz.yiming.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class FulfillOrderGatewayImpl implements FulfillOrderGateway {

    @Autowired
    private FulfillOrderDOConverter fulfillOrderDOConverter;

    @Resource
    private FulfillOrderMapper fulfillOrderMapper;

    @Override
    public void save(FulfillOrder fulfillOrder) {
        FulfillOrderDO fulfillOrderDO = fulfillOrderDOConverter.convert(fulfillOrder);
        fulfillOrderMapper.create(fulfillOrderDO);
    }

    @Override
    public void saveAllocatedWarehouse(FulfillOrder fulfillOrder, Warehouse warehouse) {
        // 提取FulfillOrder里需要的数据，以及仓库需要的一些数据
        // 基于这些数据，调用一个mapper方法，完成履约订单和分配仓库的关系的表的插入
    }

    @Override
    public void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder, LogisticsOrder logisticsOrder) {
        // 提取物流单的数据，调用一个mapper方法，完成履约订单和分配的电子物流单之间的数据插入
    }

    @Override
    public List<FulfillOrder> queryInterceptedFulfillOrders() {
        // 根据查询条件，执行一个mapper里的查询接口
        return new ArrayList<>();
    }

    @Override
    public FulfillOrder getByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Warehouse getAllocatedWarehouse(Long orderId) {
        return null;
    }

}
