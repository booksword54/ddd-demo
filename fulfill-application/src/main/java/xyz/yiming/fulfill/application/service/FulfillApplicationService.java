package xyz.yiming.fulfill.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import xyz.yiming.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import xyz.yiming.fulfill.application.command.executor.AuditInterceptedFulfillOrderCommandExecutor;
import xyz.yiming.fulfill.application.command.executor.InterceptedFulfillOrderQueryExecutor;
import xyz.yiming.fulfill.application.command.executor.OrderFulfillCommandExecutor;
import xyz.yiming.fulfill.application.command.OrderFulfillCommand;
import xyz.yiming.fulfill.application.command.query.InterceptedFulfillOrderQuery;

@Component
public class FulfillApplicationService {

    @Autowired
    private OrderFulfillCommandExecutor orderFulfillCommandExecutor;

    @Autowired
    private InterceptedFulfillOrderQueryExecutor interceptedFulfillOrderQueryExecutor;

    @Autowired
    private AuditInterceptedFulfillOrderCommandExecutor auditInterceptedFulfillOrderCommandExecutor;

    /**
     * 应用服务层，驱动命令，执行流程调度
     */
    public void executeOrderFulfill(OrderFulfillCommand orderFulfillCommand) {
        orderFulfillCommandExecutor.execute(orderFulfillCommand);
    }

    public InterceptedFulfillOrdersDTO executeInterceptedFulfillOrderQuery(InterceptedFulfillOrderQuery interceptedFulfillOrderQuery) {
        return interceptedFulfillOrderQueryExecutor.execute(interceptedFulfillOrderQuery);
    }

    public void executeAuditInterceptedFulfillOrderCommand(AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand) {
        auditInterceptedFulfillOrderCommandExecutor.execute(auditInterceptedFulfillOrderCommand);
    }

}
