package xyz.yiming.web.domain.gateway;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;

/**
 * 履约订单Gateway接口
 */
public interface FulfillOrderGateway {
    void save(FulfillOrder fulfillOrder);
}
