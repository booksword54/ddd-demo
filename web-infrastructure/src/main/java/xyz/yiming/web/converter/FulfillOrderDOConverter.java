package xyz.yiming.web.converter;

import org.springframework.stereotype.Component;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.gatewayimpl.database.dataobject.FulfillOrderDO;

@Component
public class FulfillOrderDOConverter {

    public FulfillOrderDO convert(FulfillOrder fulfillOrder) {
        return new FulfillOrderDO();
    }
}
