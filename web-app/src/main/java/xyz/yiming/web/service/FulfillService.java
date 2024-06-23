package xyz.yiming.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.command.executor.OrderFulfillCommandExecutor;
import xyz.yiming.web.command.OrderFulfillCommand;

@Component
public class FulfillService {

    @Autowired
    private OrderFulfillCommandExecutor orderFulfillCommandExecutor;

    public void executeOrderFulfill(OrderFulfillCommand orderFulfillCommand) {
        orderFulfillCommandExecutor.execute(orderFulfillCommand);
    }
}
