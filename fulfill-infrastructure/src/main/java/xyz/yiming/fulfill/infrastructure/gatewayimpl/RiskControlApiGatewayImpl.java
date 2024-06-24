package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.domain.model.fulfillorder.FulfillOrder;
import xyz.yiming.fulfill.domain.gateway.RiskControlApiGateway;

@Component
public class RiskControlApiGatewayImpl implements RiskControlApiGateway {

    // @Reference
    // private RiskControlApi riskControlApi;

    @Override
    public Boolean riskControlIntercept(FulfillOrder fulfillOrder) {
        return true;
    }
}
