package xyz.yiming.fulfill.infrastructure.gatewayimpl.mq;

import org.springframework.stereotype.Component;

@Component
public class RocketMQProducer {

    public void sendMessage(String topic, String message) {
        // 在这里面基于具体的mq技术，实现对应的发送消息的producer
        // 把消息给他，就可以把消息发送出去了
    }
}
