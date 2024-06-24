package xyz.yiming.fulfill.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.yiming.fulfill.application.command.query.InterceptedFulfillOrderQuery;
import xyz.yiming.fulfill.application.service.FulfillApplicationService;
import xyz.yiming.fulfill.web.controller.request.QueryInterceptedFulfillOrderRequest;
import xyz.yiming.fulfill.web.controller.response.QueryInterceptedFulfillOrderResponse;

@Controller
public class FulfillController {

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @GetMapping(value = "/fulfill/order/intercepted")
    public QueryInterceptedFulfillOrderResponse queryInterceptedFulfillOrders(
            @RequestBody QueryInterceptedFulfillOrderRequest queryInterceptedFulfillOrderRequest) {
        // 将Request请求转成Query命令
        InterceptedFulfillOrderQuery interceptedFulfillOrderQuery = new InterceptedFulfillOrderQuery();
        // 交给 applicationService进行处理
        fulfillApplicationService.executeInterceptedFulfillOrderQuery(interceptedFulfillOrderQuery);
        
        return null;
    }
}
