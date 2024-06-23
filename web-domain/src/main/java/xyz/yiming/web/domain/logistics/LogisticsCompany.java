package xyz.yiming.web.domain.logistics;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.warehouse.Warehouse;

public class LogisticsCompany {

    /**
     * 申请电子面单
     */
    public LogisticsOrder applyLogisticsOrder(FulfillOrder fulfillOrder, Warehouse warehouse) {
        return new LogisticsOrder();
    }

}
