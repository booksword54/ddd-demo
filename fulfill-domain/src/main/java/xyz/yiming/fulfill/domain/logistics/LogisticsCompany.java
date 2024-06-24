package xyz.yiming.fulfill.domain.logistics;

import xyz.yiming.fulfill.domain.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.warehouse.Warehouse;

public class LogisticsCompany {

    /**
     * 申请电子面单
     */
    public LogisticsOrder applyLogisticsOrder(FulfillOrder fulfillOrder, Warehouse warehouse) {
        return new LogisticsOrder();
    }

}
