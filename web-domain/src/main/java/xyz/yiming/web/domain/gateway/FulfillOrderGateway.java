package xyz.yiming.web.domain.gateway;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.logistics.LogisticsOrder;
import xyz.yiming.web.domain.warehouse.Warehouse;

/**
 * 履约订单Gateway接口
 */
public interface FulfillOrderGateway {

    void save(FulfillOrder fulfillOrder);

    void saveAllocatedWarehouse(FulfillOrder fulfillOrder, Warehouse warehouse);

    void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder, LogisticsOrder logisticsOrder);

}
