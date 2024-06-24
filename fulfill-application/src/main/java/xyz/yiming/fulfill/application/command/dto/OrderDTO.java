package xyz.yiming.fulfill.application.command.dto;

/**
 * 订单数据对象
 */
public class OrderDTO {

    private Long orderId;

    public OrderDTO(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderDTO setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }
}
