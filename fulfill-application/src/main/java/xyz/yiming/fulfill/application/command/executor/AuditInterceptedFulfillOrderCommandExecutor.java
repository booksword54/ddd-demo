package xyz.yiming.fulfill.application.command.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.application.command.AuditInterceptedFulfillOrderCommand;
import xyz.yiming.fulfill.application.command.dto.InterceptedFulfillOrderAuditResultDTO;
import xyz.yiming.fulfill.domain.event.OrderFulfillDeniedEvent;
import xyz.yiming.fulfill.domain.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.DomainEventGateway;
import xyz.yiming.fulfill.domain.gateway.FulfillOrderGateway;
import xyz.yiming.fulfill.domain.gateway.WarehouseApiGateway;
import xyz.yiming.fulfill.domain.service.LogisticsDomainService;
import xyz.yiming.fulfill.domain.warehouse.Warehouse;

@Component
public class AuditInterceptedFulfillOrderCommandExecutor {

    @Autowired
    private LogisticsDomainService logisticsDomainService;

    @Autowired
    private FulfillOrderGateway fulfillOrderGateway;

    @Autowired
    private WarehouseApiGateway warehouseApiGateway;

    @Autowired
    private DomainEventGateway domainEventGateway;

    public void execute(AuditInterceptedFulfillOrderCommand auditInterceptedFulfillOrderCommand) {
        InterceptedFulfillOrderAuditResultDTO interceptedFulfillOrderAuditResultDTO =
                auditInterceptedFulfillOrderCommand.getInterceptedFulfillOrderAuditResultDTO();
        Long orderId = interceptedFulfillOrderAuditResultDTO.getOrderId();
        Boolean auditResult = interceptedFulfillOrderAuditResultDTO.getAuditResult();
        if (auditResult) {
            // 进行流程编排，核心步骤：领域模型建模、业务流程还原通过domain层的领域服务、领域模型和业务组件进行实现
            FulfillOrder fulfillOrder = fulfillOrderGateway.getByOrderId(orderId);
            Warehouse warehouse = fulfillOrderGateway.getAllocatedWarehouse(orderId);
            // 分物流
            logisticsDomainService.allocateLogistics(fulfillOrder, warehouse);
            // 下库房
            warehouseApiGateway.sendFulfillOrder(fulfillOrder, warehouse);
        } else {
            OrderFulfillDeniedEvent orderFulfillDeniedEvent = new OrderFulfillDeniedEvent();
            domainEventGateway.publishOrderFulfillDeniedEvent(orderFulfillDeniedEvent);
        }
    }

}
