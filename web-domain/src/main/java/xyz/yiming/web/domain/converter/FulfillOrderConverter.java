package xyz.yiming.web.domain.converter;

import org.springframework.stereotype.Component;
import xyz.yiming.web.command.dto.OrderDTO;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;

/**
 * 履约订单领域模型的转换器
 */
@Component
public class FulfillOrderConverter {

    public FulfillOrder convert(OrderDTO orderDTO) {
        return new FulfillOrder();
    }

}
