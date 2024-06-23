package xyz.yiming.web.domainevent.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.command.dto.OrderDTO;
import xyz.yiming.web.domainevent.OrderPayedEvent;
import xyz.yiming.web.command.OrderFulfillCommand;
import xyz.yiming.web.service.FulfillService;

/**
 * 订单已支付领域事件的具体处理逻辑
 */
@Component
public class OrderPayedEventHandler {

    @Autowired
    private FulfillService fulfillService;

    public void handle(OrderPayedEvent orderPayedEvent) {
        // 必须把领域事件，转换为一个command，交给service去路由给对应的executor做一个处理
        Long orderId = orderPayedEvent.getOrderId();
        OrderDTO orderDTO = new OrderDTO(orderId);
        OrderFulfillCommand orderFulfillCommand = new OrderFulfillCommand(orderDTO);
        fulfillService.executeOrderFulfill(orderFulfillCommand);
    }
}
