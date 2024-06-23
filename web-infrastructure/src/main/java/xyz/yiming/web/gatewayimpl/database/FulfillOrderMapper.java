package xyz.yiming.web.gatewayimpl.database;

import org.apache.ibatis.annotations.Mapper;
import xyz.yiming.web.gatewayimpl.database.dataobject.FulfillOrderDO;

@Mapper
public interface FulfillOrderMapper {

    int create(FulfillOrderDO fulfillOrderDO);

}
