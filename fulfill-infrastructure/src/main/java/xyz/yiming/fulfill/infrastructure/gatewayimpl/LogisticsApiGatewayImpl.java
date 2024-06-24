package xyz.yiming.fulfill.infrastructure.gatewayimpl;

import org.springframework.stereotype.Component;
import xyz.yiming.web.domain.gateway.LogisticsApiGateway;
import xyz.yiming.web.domain.logistics.LogisticsCompanies;

@Component
public class LogisticsApiGatewayImpl implements LogisticsApiGateway {

    @Override
    public LogisticsCompanies getAll() {
        return new LogisticsCompanies();
    }

}
