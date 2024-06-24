package xyz.yiming.fulfill.infrastructure.converter;

import org.springframework.stereotype.Component;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;

@Component
public class FulfillOrderDOConverter {

    public FulfillOrderDO convert(FulfillOrder fulfillOrder) {
        return new FulfillOrderDO();
    }
}
