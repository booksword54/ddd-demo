package xyz.yiming.web.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.command.executor.OrderFulfillCommandExecutor;
import xyz.yiming.web.command.OrderFulfillCommand;

@Component
public class FulfillService {

    @Autowired
    private OrderFulfillCommandExecutor orderFulfillCommandExecutor;

    /**
     * 应用服务层，驱动命令，执行流程调度
     */
    public void executeOrderFulfill(OrderFulfillCommand orderFulfillCommand) {
        orderFulfillCommandExecutor.execute(orderFulfillCommand);
    }
}
