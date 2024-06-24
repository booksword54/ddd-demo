package xyz.yiming.fulfill.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.yiming.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import xyz.yiming.fulfill.application.command.dto.InterceptedFulfillOrdersDTO;
import xyz.yiming.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import xyz.yiming.fulfill.application.service.FulfillApplicationService;
import xyz.yiming.fulfill.api.web.request.AuditInterceptedFulfillOrderRequest;
import xyz.yiming.fulfill.api.web.request.QueryInterceptedFulfillOrderRequest;
import xyz.yiming.fulfill.api.web.response.AuditInterceptedFulfillOrderResponse;
import xyz.yiming.fulfill.api.web.response.QueryInterceptedFulfillOrderResponse;

@Controller
public class FulfillController {

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    /**
     * 风控拦截订单查询
     */
    @PostMapping(value = "/fulfill/order/intercepted")
    public QueryInterceptedFulfillOrderResponse queryInterceptedFulfillOrders(
            @RequestBody QueryInterceptedFulfillOrderRequest queryInterceptedFulfillOrderRequest) {
        // 将Request请求转成application层的Query命令
        InterceptedFulfillOrderQuery interceptedFulfillOrderQuery = new InterceptedFulfillOrderQuery();
        // 将Query交给 applicationService进行处理
        InterceptedFulfillOrdersDTO interceptedFulfillOrdersDTO = fulfillApplicationService.executeInterceptedFulfillOrderQuery(interceptedFulfillOrderQuery);
        // 将application返回的DTO转换成web层的Response，返回给请求者
        return new QueryInterceptedFulfillOrderResponse();
    }

    /**
     * 风控拦截订单审核
     */
    @PostMapping(value = "/fulfill/order/intercepted/audit")
    public AuditInterceptedFulfillOrderResponse auditInterceptedFulfillOrders(
            @RequestBody AuditInterceptedFulfillOrderRequest auditInterceptedFulfillOrderRequest) {
        // 将Request请求转成application层的Command命令
        AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand = new AuditInterceptedFulfillOrderCommand();
        // 将Command交给 applicationService进行处理
        fulfillApplicationService.executeAuditInterceptedFulfillOrderCommand(auditInterceptedFulfillOrderCommand);
        // 将application返回的DTO转换成web层的Response，返回给请求者
        return new AuditInterceptedFulfillOrderResponse();
    }
}
