package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.infrastructure.gatewayimpl.mq.RocketMQProducer;
import xyz.yiming.web.domain.event.OrderInterceptedEvent;
import xyz.yiming.web.domain.gateway.DomainEventGateway;

@Component
public class DomainEventGatewayImpl implements DomainEventGateway {

    @Autowired
    private RocketMQProducer rocketMQProducer;

    @Override
    public void publishOrderInterceptedEvent(OrderInterceptedEvent orderInterceptedEvent) {
        // 需要把订单被拦截的事件转换成对应的mq message消息
        String message = "OrderInterceptedEvent Message";
        rocketMQProducer.sendMessage("OrderInterceptedEventTopic", message);
    }
}
