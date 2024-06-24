package xyz.yiming.fulfill.infrastructure.gatewayimpl.database;

import org.apache.ibatis.annotations.Mapper;
import xyz.yiming.fulfill.infrastructure.gatewayimpl.database.dataobject.FulfillOrderDO;

@Mapper
public interface FulfillOrderMapper {

    int create(FulfillOrderDO fulfillOrderDO);

}
