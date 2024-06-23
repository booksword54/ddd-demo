package xyz.yiming.web.domain.gateway;

import xyz.yiming.web.domain.warehouse.WareHouses;

import java.util.List;

/**
 * 仓储域的路由接口
 */
public interface WareHouseGateway {
    /**
     * 拿到所有仓库信息
     */
    WareHouses getAll();

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
}
