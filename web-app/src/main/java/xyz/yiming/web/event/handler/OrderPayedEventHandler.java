package xyz.yiming.web.event.handler;

import org.springframework.stereotype.Component;
import xyz.yiming.web.domainevent.OrderPayedEvent;

/**
 * 订单已支付领域事件的具体处理逻辑
 */
@Component
public class OrderPayedEventHandler {

    public void handle(OrderPayedEvent orderPayedEvent) {
        // 必须把领域事件，转换为一个command，交给service去路由给对应的executor做一个处理

    }
}
