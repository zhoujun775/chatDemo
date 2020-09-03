package com.junz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created By Junz on 2020/9/2.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}

/*
* @EnableWebSocketMessageBroker用于启用我们的WebSocket服务器。

我们实现了WebSocketMessageBrokerConfigurer接口，并实现了其中的方法。

在第一种方法中，我们注册一个websocket端点，客户端将使用它连接到我们的websocket服务器。

withSockJS()是用来为不支持websocket的浏览器启用后备选项，使用了SockJS。

方法名中的STOMP是来自Spring框架STOMP实现。 STOMP代表简单文本导向的消息传递协议。它是一种消息传递协议，用于定义数据交换的格式和规则。为啥我们需要这个东西？因为WebSocket只是一种通信协议。它没有定义诸如以下内容：如何仅向订阅特定主题的用户发送消息，或者如何向特定用户发送消息。我们需要STOMP来实现这些功能。

在configureMessageBroker方法中，我们配置一个消息代理，用于将消息从一个客户端路由到另一个客户端。

第一行定义了以“/app”开头的消息应该路由到消息处理方法（之后会定义这个方法）。

第二行定义了以“/topic”开头的消息应该路由到消息代理。消息代理向订阅特定主题的所有连接客户端广播消息。

在上面的示例中，我们使用的是内存中的消息代理。

之后也可以使用RabbitMQ或ActiveMQ等其他消息代理。
* */
