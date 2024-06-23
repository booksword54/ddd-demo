package xyz.yiming.web.domain.warehouse;

import xyz.yiming.web.domain.fulfillorder.DeliveryAddress;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;

/**
 * 仓库集合领域模型
 */
public class Warehouses {

    public Warehouse selectNearest(DeliveryAddress deliveryAddress) {
        return new Warehouse();
    }
}
