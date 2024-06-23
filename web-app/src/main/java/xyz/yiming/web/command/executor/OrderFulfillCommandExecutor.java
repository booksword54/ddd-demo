package xyz.yiming.web.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.command.OrderFulfillCommand;
import xyz.yiming.web.command.dto.OrderDTO;
import xyz.yiming.web.domain.converter.FulfillOrderConverter;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;

/**
 * 订单履约命令(流程)的执行器
 */
@Component
public class OrderFulfillCommandExecutor {

    @Autowired
    private FulfillOrderConverter fulfillOrderConverter;

    // 专门负责订单履约流程的编排，把这个流程按照业务战术建模的设计，完成落地开发
    public void execute(OrderFulfillCommand orderFulfillCommand) {
        // 第一步：保存订单，需要去使用履约订单仓储进行保存
        OrderDTO orderDTO = orderFulfillCommand.getOrderCO();
        FulfillOrder fulfillOrder = fulfillOrderConverter.convert(orderDTO);
    }
}
