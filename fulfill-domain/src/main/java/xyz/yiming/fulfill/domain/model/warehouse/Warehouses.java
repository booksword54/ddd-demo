package xyz.yiming.fulfill.domain.model.warehouse;

import xyz.yiming.fulfill.domain.model.fulfillorder.DeliveryAddress;

/**
 * 仓库集合领域模型
 */
public class Warehouses {

    public Warehouse selectNearest(DeliveryAddress deliveryAddress) {
        return new Warehouse();
    }
}
