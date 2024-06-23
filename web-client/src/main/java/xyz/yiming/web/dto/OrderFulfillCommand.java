package xyz.yiming.web.dto;

import xyz.yiming.web.clientobject.OrderCO;

/**
 * 发起一个订单履约的命令
 */
public class OrderFulfillCommand {

    private OrderCO orderCO;

    public OrderFulfillCommand(OrderCO orderCO) {
        this.orderCO = orderCO;
    }

    public OrderCO getOrderCO() {
        return orderCO;
    }

    public OrderFulfillCommand setOrderCO(OrderCO orderCO) {
        this.orderCO = orderCO;
        return this;
    }
}
