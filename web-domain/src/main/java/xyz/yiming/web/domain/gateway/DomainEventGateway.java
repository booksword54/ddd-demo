package xyz.yiming.web.domain.gateway;

import xyz.yiming.web.domain.event.OrderInterceptedEvent;

public interface DomainEventGateway {

    void publishOrderInterceptedEvent(OrderInterceptedEvent orderInterceptedEvent);

}
