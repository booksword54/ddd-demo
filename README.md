web：接口层，controller来组成，直接跟外界进行交互，listener/consumer

client：api、dto/client object

application service：应用服务层，主要是业务流程编排，service、executor、scheduler、domain event+handler、command+dto/query

domain：aggregate+entity+value object、domain service、business component、gateway/repository -> 把业务模型、业务流程、业务语义，完全用代码还原出来，让代码跟业务吻合，而不是完全从技术角度、数据库角度去设计和写出来的代码

infrastructure：基础设施层，do+repository impl，他主要是负责跟具体的基础设施进行交互，跟数据库、MQ、缓存、ES、nosql以及其他的外部的基础设施一类的系统进行一个交互，偏向于技术流的地方，主要就是在这里
