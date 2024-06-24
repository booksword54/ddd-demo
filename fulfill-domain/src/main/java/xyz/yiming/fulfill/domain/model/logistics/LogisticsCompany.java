package xyz.yiming.fulfill.domain.model.logistics;

import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.model.warehouse.Warehouse;

public class LogisticsCompany {

    /**
     * 申请电子面单
     */
    public LogisticsOrder applyLogisticsOrder(FulfillOrder fulfillOrder, Warehouse warehouse) {
        return new LogisticsOrder();
    }

}
