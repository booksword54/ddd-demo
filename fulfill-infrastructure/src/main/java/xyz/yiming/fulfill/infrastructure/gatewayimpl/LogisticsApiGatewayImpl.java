package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.stereotype.Component;
import xyz.yiming.fulfill.domain.gateway.LogisticsApiGateway;
import xyz.yiming.fulfill.domain.logistics.LogisticsCompanies;

@Component
public class LogisticsApiGatewayImpl implements LogisticsApiGateway {

    @Override
    public LogisticsCompanies getAll() {
        return new LogisticsCompanies();
    }

}
