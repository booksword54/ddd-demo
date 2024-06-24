package xyz.yiming.fulfill.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.executor.OrderFulfillCommandExecutor;
import xyz.yiming.fulfill.application.command.OrderFulfillCommand;

@Component
public class FulfillApplicationService {

    @Autowired
    private OrderFulfillCommandExecutor orderFulfillCommandExecutor;

    /**
     * 应用服务层，驱动命令，执行流程调度
     */
    public void executeOrderFulfill(OrderFulfillCommand orderFulfillCommand) {
        orderFulfillCommandExecutor.execute(orderFulfillCommand);
    }
}
