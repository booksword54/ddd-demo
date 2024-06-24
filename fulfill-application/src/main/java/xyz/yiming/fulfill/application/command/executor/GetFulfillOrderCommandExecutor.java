package xyz.yiming.fulfill.application.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.GetFulfillOrderCommand;
import xyz.yiming.fulfill.application.command.dto.FulfillOrderDTO;
import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.FulfillOrderGateway;

@Component
public class GetFulfillOrderCommandExecutor {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    public FulfillOrderDTO execute(GetFulfillOrderCommand getFulfillOrderCommand) {
        Long orderId = getFulfillOrderCommand.getOrderId();
        FulfillOrder fulfillOrder = fulfillOrderGateway.getByOrderId(orderId);
        // 再把领域模型层的fulfill order转换为dto对象
        return new FulfillOrderDTO();
    }

}
