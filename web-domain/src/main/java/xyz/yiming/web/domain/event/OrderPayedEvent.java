package xyz.yiming.web.domain.event;

/**
 * 订单已支付领域事件
 */
public class OrderPayedEvent {
    /**
     * 订单id
     */
    private Long orderId;

    // 在这里正常来说，是可以包含一份完整的订单数据的

    public OrderPayedEvent(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderPayedEvent setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }
}
