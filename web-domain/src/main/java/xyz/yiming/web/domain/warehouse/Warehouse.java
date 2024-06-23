package xyz.yiming.web.domain.warehouse;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.fulfillorder.FulfillOrderItem;
import xyz.yiming.web.domain.gateway.WarehouseApiGateway;

import java.util.List;

/**
 * 仓库的领域模型
 */
public class Warehouse {

    private Long warehouseId;

    private WarehouseApiGateway wareHouseApiGateway;

    public Boolean isInventoryEnough(List<FulfillOrderItem> fulfillOrderItems) {
        return true;
    }

    public Boolean lockInventory(FulfillOrder fulfillOrder) {
        return wareHouseApiGateway.lockInventory(warehouseId,
                                                 fulfillOrder.getOrderId(),
                                                 fulfillOrder.getSkuCodes(),
                                                 fulfillOrder.getPurchaseCounts());
    }

    public void setWareHouseGateway(WarehouseApiGateway wareHouseApiGateway) {
        this.wareHouseApiGateway = wareHouseApiGateway;
    }

}
