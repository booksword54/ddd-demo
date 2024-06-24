package xyz.yiming.fulfill.domain.gateway;

import xyz.yiming.fulfill.domain.event.OrderInterceptedEvent;

public interface DomainEventGateway {

    void publishOrderInterceptedEvent(OrderInterceptedEvent orderInterceptedEvent);

}
