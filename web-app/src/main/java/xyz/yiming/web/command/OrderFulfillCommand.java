package xyz.yiming.web.command;

import xyz.yiming.web.command.dto.OrderDTO;

/**
 * 发起一个订单履约的命令
 */
public class OrderFulfillCommand {

    private OrderDTO orderDTO;

    public OrderFulfillCommand(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public OrderDTO getOrderCO() {
        return orderDTO;
    }

    public OrderFulfillCommand setOrderCO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
        return this;
    }
}
