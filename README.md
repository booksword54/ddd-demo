## Adapter层

web：处理请求的Controller

wireless：处理无线端适配

wap：处理wap端适配


## App层

executor：处理request、包括command和query

consumer：处理外部meaages

scheduler：处理定时任务


## Domain层

model：领域模型

ability：领域能力，包括DomainService

gateway：领域网关，解耦利器


## Infrastructure层

gatewayImpl：网关实现

mapper：MyBatis数据库映射

config：配置信息


## Client SDK

api：服务对外透出的API

dto：服务对外的DTO
