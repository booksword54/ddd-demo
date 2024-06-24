package xyz.yiming.fulfill.application.command;

public class GetFulfillOrderCommand {

    private Long orderId;

    public GetFulfillOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public GetFulfillOrderCommand setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }
}
