package xyz.yiming.fulfill.domain.gateway;

import xyz.yiming.fulfill.domain.logistics.LogisticsCompanies;

/**
 * Api  RPC网关路由接口
 * 领域模型 数据存储网关接口
 * 领域事件 MQ消息发送网关接口
 */
public interface LogisticsApiGateway {

    LogisticsCompanies getAll();

}
