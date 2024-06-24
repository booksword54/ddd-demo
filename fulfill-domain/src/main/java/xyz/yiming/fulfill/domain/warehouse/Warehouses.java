package xyz.yiming.fulfill.domain.warehouse;

import xyz.yiming.fulfill.domain.fulfillorder.DeliveryAddress;

/**
 * 仓库集合领域模型
 */
public class Warehouses {

    public Warehouse selectNearest(DeliveryAddress deliveryAddress) {
        return new Warehouse();
    }
}
