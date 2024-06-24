package xyz.yiming.fulfill.application.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.dto.OrderDTO;
import xyz.yiming.fulfill.application.converter.FulfillOrderConverter;
import xyz.yiming.fulfill.application.command.OrderFulfillCommand;
import xyz.yiming.fulfill.domain.event.OrderInterceptedEvent;
import xyz.yiming.fulfill.domain.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.DomainEventGateway;
import xyz.yiming.fulfill.domain.gateway.FulfillOrderGateway;
import xyz.yiming.fulfill.domain.gateway.RiskControlApiGateway;
import xyz.yiming.fulfill.domain.gateway.WarehouseApiGateway;
import xyz.yiming.fulfill.domain.service.LogisticsDomainService;
import xyz.yiming.fulfill.domain.service.WarehouseDomainService;
import xyz.yiming.fulfill.domain.warehouse.Warehouse;

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

    @Autowired
    private RiskControlApiGateway riskControlApiGateway;

    @Autowired
    private DomainEventGateway domainEventGateway;

    @Autowired
    private LogisticsDomainService logisticsDomainService;

    @Autowired
    private WarehouseApiGateway warehouseApiGateway;

    // 专门负责订单履约流程的编排，把这个流程按照业务战术建模的设计，完成落地开发
    // 可以调用聚合模型的行为、仓储/网关、外界API路由、领域服务
    public void execute(OrderFulfillCommand orderFulfillCommand) {
        // 第一步：保存订单，需要去使用履约订单仓储/Gateway进行保存
        OrderDTO orderDTO = orderFulfillCommand.getOrderCO();
        FulfillOrder fulfillOrder = fulfillOrderConverter.convert(orderDTO);
        // 通过网关路由到基础设施进行保存
        // 调用网关
        fulfillOrderGateway.save(fulfillOrder);

        // 第二步：预分仓
        // 调用领域服务
        Warehouse warehouse = warehouseDomainService.preAllocateWarehouse(fulfillOrder);

        // 第三步：风控拦截
        Boolean riskedControlInterceptResult = riskControlApiGateway.riskControlIntercept(fulfillOrder);
        if (!riskedControlInterceptResult) {
            domainEventGateway.publishOrderInterceptedEvent(new OrderInterceptedEvent());
            return;
        }

        // 第四步：分物流
        logisticsDomainService.allocateLogistics(fulfillOrder, warehouse);

        // 第五步：下发库房
        warehouseApiGateway.sendFulfillOrder(fulfillOrder, warehouse);
    }
}
