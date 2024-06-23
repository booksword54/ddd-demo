package xyz.yiming.web.command.clientobject;

/**
 * 订单数据对象
 */
public class OrderCO {

    private Long orderId;

    public OrderCO(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderCO setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }
}
