package xyz.yiming.web.gatewayimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.converter.FulfillOrderDOConverter;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.gateway.FulfillOrderGateway;
import xyz.yiming.web.domain.warehouse.Warehouse;
import xyz.yiming.web.gatewayimpl.database.FulfillOrderMapper;
import xyz.yiming.web.gatewayimpl.database.dataobject.FulfillOrderDO;

import javax.annotation.Resource;

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
        // 基于这些数据，调用一个mapper方法，宛城履约订单和分配仓库的关系的表的插入
    }

}
