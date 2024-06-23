package xyz.yiming.web.gatewayimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.converter.FulfillOrderDOConverter;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.gateway.FulfillOrderGateway;
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
}
