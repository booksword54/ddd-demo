package xyz.yiming.web.domain.gateway;

import xyz.yiming.web.domain.fulfillorder.FulfillOrder;

/**
 * 风控子域API接口
 */
public interface RiskControlApiGateway {

    Boolean riskControlIntercept(FulfillOrder fulfillOrder);

}
