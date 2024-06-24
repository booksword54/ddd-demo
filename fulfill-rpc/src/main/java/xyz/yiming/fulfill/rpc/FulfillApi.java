package xyz.yiming.fulfill.rpc;

import xyz.yiming.fulfill.rpc.clientobject.FulfillOrderCO;

public interface FulfillApi {

    FulfillOrderCO getFulfillOrderById(Long orderId);

}
