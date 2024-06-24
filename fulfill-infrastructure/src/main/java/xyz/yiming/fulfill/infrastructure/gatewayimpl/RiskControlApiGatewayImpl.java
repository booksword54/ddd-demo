package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.stereotype.Component;
import xyz.yiming.web.domain.fulfillorder.FulfillOrder;
import xyz.yiming.web.domain.gateway.RiskControlApiGateway;

@Component
public class RiskControlApiGatewayImpl implements RiskControlApiGateway {

    // @Reference
    // private RiskControlApi riskControlApi;

    @Override
    public Boolean riskControlIntercept(FulfillOrder fulfillOrder) {
        return true;
    }
}
