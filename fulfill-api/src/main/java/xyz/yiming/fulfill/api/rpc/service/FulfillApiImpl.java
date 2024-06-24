package xyz.yiming.fulfill.api.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.yiming.fulfill.application.command.GetFulfillOrderCommand;
import xyz.yiming.fulfill.application.command.dto.FulfillOrderDTO;
import xyz.yiming.fulfill.application.service.FulfillApplicationService;
import xyz.yiming.fulfill.rpc.FulfillApi;
import xyz.yiming.fulfill.rpc.clientobject.FulfillOrderCO;

// 加上dubbo的@Service注解，基于dubbo对外提供rpc服务
public class FulfillApiImpl implements FulfillApi {

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    @Override
    public FulfillOrderCO getFulfillOrderById(Long orderId) {
        GetFulfillOrderCommand getFulfillOrderCommand = new GetFulfillOrderCommand(orderId);
        FulfillOrderDTO fulfillOrderDTO =  fulfillApplicationService.executeGetFulfillOrderCommand(getFulfillOrderCommand);
        // 将DTO转换为面向客户端的CO对象
        return new FulfillOrderCO();
    }

}
