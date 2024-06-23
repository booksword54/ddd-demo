package xyz.yiming.web.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.web.command.OrderFulfillCommand;
import xyz.yiming.web.command.dto.OrderDTO;
import xyz.yiming.web.domain.converter.FulfillOrderConverter;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.gateway.FulfillOrderGateway;
import xyz.yiming.web.domain.service.WarehouseDomainService;

/**
 * 订单履约命令(流程)的执行器
 */
@Component
public class OrderFulfillCommandExecutor {

    @Autowired
    private FulfillOrderConverter fulfillOrderConverter;

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    @Autowired
    private WarehouseDomainService warehouseDomainService;

    // 专门负责订单履约流程的编排，把这个流程按照业务战术建模的设计，完成落地开发
    // 可以调用聚合模型的行为、仓储/网关、外界API路由、领域服务
    public void execute(OrderFulfillCommand orderFulfillCommand) {
        // 第一步：保存订单，需要去使用履约订单仓储/Gateway进行保存
        OrderDTO orderDTO = orderFulfillCommand.getOrderCO();
        FulfillOrder fulfillOrder = fulfillOrderConverter.convert(orderDTO);
        // 通过网关路由到基础设施进行保存
        fulfillOrderGateway.save(fulfillOrder);

        // 第二步：预分仓
        warehouseDomainService.preAllocateWarehouse(fulfillOrder);

        // 第三步：风控拦截


        // 第四步：分物流

        // 第五步：下发库房

    }
}
