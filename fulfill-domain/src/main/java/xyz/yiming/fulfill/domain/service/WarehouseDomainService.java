package xyz.yiming.fulfill.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.WarehouseApiGateway;
import xyz.yiming.fulfill.domain.model.warehouse.Warehouse;
import xyz.yiming.fulfill.domain.model.warehouse.Warehouses;

/**
 * 仓储领域模型服务
 * 领域服务层，结合领域模型、基础设施还原业务语义
 */
@Component
public class WarehouseDomainService {

    @Autowired
    private WarehouseApiGateway warehouseApiGateway;

    public Warehouse preAllocateWarehouse(FulfillOrder fulfillOrder) {
        // 查询所有的仓库信息
        Warehouses warehouses = warehouseApiGateway.getAll();
        // 从所有的仓库里选择一个距离订单收货地址最近的仓库
        Warehouse warehouse = warehouses.selectNearest(fulfillOrder.getDeliveryAddress());
        // 检查选择的仓库对订单订购的商品数量，库存是否充足
        if (warehouse.isInventoryEnough(fulfillOrder.getFulfillOrderItems())) {
            // 对选择的仓库，将订单订购的商品的库存进行锁定
            warehouse.lockInventory(fulfillOrder);
            // 将履约订单分配给选择的仓库
            fulfillOrder.allocateToWarehouse(warehouse);
            return warehouse;
        }
        return null;
    }
}
