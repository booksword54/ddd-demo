package xyz.yiming.web.domain.warehouse;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.gateway.WareHouseGateway;

/**
 * 仓库的领域模型
 */
public class WareHouse {

    private Long warehouseId;

    private WareHouseGateway wareHouseGateway;

    public Boolean checkInventory(FulfillOrder fulfillOrder) {
        return true;
    }

    public Boolean lockInventory(FulfillOrder fulfillOrder) {
        return wareHouseGateway.lockInventory(warehouseId,
                                              fulfillOrder.getOrderId(),
                                              fulfillOrder.getSkuCodes(),
                                              fulfillOrder.getPurchaseCounts());
    }

    public void setWareHouseGateway(WareHouseGateway wareHouseGateway) {
        this.wareHouseGateway = wareHouseGateway;
    }

}
