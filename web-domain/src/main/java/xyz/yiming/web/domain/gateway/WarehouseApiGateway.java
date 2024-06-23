package xyz.yiming.web.domain.gateway;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.warehouse.Warehouse;
import xyz.yiming.web.domain.warehouse.Warehouses;

import java.util.List;

/**
 * 仓储域的路由接口
 * 对仓储上下文进行调用
 */
public interface WarehouseApiGateway {
    /**
     * 拿到所有仓库信息
     */
    Warehouses getAll();

    /**
     * 锁定库存
     * @param warehouseId 仓库id
     * @param orderId 订单id
     * @param skuCode sku编码
     * @param inventoryCount 库存数量
     * @return true 成功 false 失败
     */
    Boolean lockInventory(Long warehouseId,
                          Long orderId,
                          List<String> skuCode,
                          List<Long> inventoryCount);

    void sendFulfillOrder(FulfillOrder fulfillOrder, Warehouse warehouse);
}
