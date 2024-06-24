package xyz.yiming.fulfill.application.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import xyz.yiming.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import xyz.yiming.fulfill.domain.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.FulfillOrderGateway;

import java.util.List;

@Component
public class InterceptedFulfillOrderQueryExecutor {

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    public InterceptedFulfillOrdersDTO execute(InterceptedFulfillOrderQuery interceptedFulfillOrderQuery) {
        List<FulfillOrder> fulfillOrders = fulfillOrderGateway.queryInterceptedFulfillOrders();
        // 将领域模型转换为DTO，进行返回
        return new InterceptedFulfillOrdersDTO();
    }

}
