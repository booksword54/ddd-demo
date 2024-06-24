package xyz.yiming.fulfill.domain.gateway;

import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;

/**
 * 风控子域API接口
 */
public interface RiskControlApiGateway {

    Boolean riskControlIntercept(FulfillOrder fulfillOrder);

}
