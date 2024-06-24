package xyz.yiming.fulfill.domain.gateway;

import xyz.yiming.fulfill.domain.logistics.LogisticsOrder;
import xyz.yiming.fulfill.domain.warehouse.Warehouse;
import xyz.yiming.fulfill.domain.fulfillorder.FulfillOrder;

import java.util.List;

/**
 * 履约订单Gateway接口
 */
public interface FulfillOrderGateway {

    void save(FulfillOrder fulfillOrder);

    void saveAllocatedWarehouse(FulfillOrder fulfillOrder, Warehouse warehouse);

    void saveAllocatedLogisticsOrder(FulfillOrder fulfillOrder, LogisticsOrder logisticsOrder);

    List<FulfillOrder> queryInterceptedFulfillOrders();

}
