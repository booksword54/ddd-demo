package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.domain.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.WarehouseApiGateway;
import xyz.yiming.fulfill.domain.warehouse.Warehouse;
import xyz.yiming.fulfill.domain.warehouse.Warehouses;

import java.util.List;

@Component
public class WarehouseApiGatewayImpl implements WarehouseApiGateway {

    // 如果RPC框架使用的Dubbo，可以去依赖 dubbo reference，
    // 可以远程调用仓储上下文的API
    // @Reference
    // private WarehouseApi warehouseApi;

    @Override
    public Warehouses getAll() {
        return new Warehouses();
    }

    @Override
    public Boolean lockInventory(Long warehouseId, Long orderId, List<String> skuCode, List<Long> inventoryCount) {
        return true;
    }

    @Override
    public void sendFulfillOrder(FulfillOrder fulfillOrder, Warehouse warehouse) {

    }
}
