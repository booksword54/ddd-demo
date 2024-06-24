package xyz.yiming.fulfill.web.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.yiming.fulfill.application.service.FulfillApplicationService;
import xyz.yiming.fulfill.application.command.OrderFulfillCommand;
import xyz.yiming.fulfill.application.command.dto.OrderDTO;
import xyz.yiming.fulfill.domain.event.OrderPayedEvent;

/**
 * 订单已支付领域事件的消费者
 */
public class OrderPayedEventConsumer {
    // 具体的消费逻辑，依赖具体的MQ技术做一个实现
    // 正常自己有一个启动，启动之后，启动一个consumer，监听指定mq的topic
    // 在这里可以开发具体的mq消费监听逻辑
    // 拿到对应的消息之后，此时就可以交给对应的event handler来做一个处理就可以

    @Autowired
    private FulfillApplicationService fulfillApplicationService;

    public void startConsume() {
        // 通过mq的消费技术，拿到一个个的message，一般来说都是json格式的字符串
        // 在这里把message转化为一个个OrderPayedEvent领域事件
        OrderPayedEvent orderPayedEvent = new OrderPayedEvent(1100L);
        // 必须把领域事件，转换为一个command，交给service去路由给对应的executor做一个处理
        Long orderId = orderPayedEvent.getOrderId();
        OrderDTO orderDTO = new OrderDTO(orderId);
        OrderFulfillCommand orderFulfillCommand = new OrderFulfillCommand(orderDTO);
        // 交给app层的应用服务逻辑，去推动命令的流程编排和执行
        fulfillApplicationService.executeOrderFulfill(orderFulfillCommand);

        // 处理mq技术相关的细节，比如说offset的管理，是否进行重试消费，以及其他的一些细节

    }
}
