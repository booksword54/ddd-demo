package xyz.yiming.fulfill.application.converter;

import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.dto.OrderDTO;
import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;

/**
 * 履约订单领域模型的转换器
 */
@Component
public class FulfillOrderConverter {

    public FulfillOrder convert(OrderDTO orderDTO) {
        return new FulfillOrder();
    }

}
