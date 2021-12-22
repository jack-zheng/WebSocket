package com.jiabin.chat.config;

import com.jiabin.chat.config.interceptor.ChatHandshakeInterceptor;
import com.jiabin.chat.service.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private ChatHandler chatHandler;

    @Autowired
    private ChatHandshakeInterceptor chatHandshakeInterceptor;

    /**
     * 注册WebSocket处理器
     * 配置处理器、拦截器、允许域、SockJs支持
     *
     * @param registry registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/chatHandler")
                .addInterceptors(chatHandshakeInterceptor);

        // 当浏览器不支持WebSocket，使用SockJs支持
        //registry.addHandler(chatHandler, "/sockjs-chatHandler")
        //        .addInterceptors(chatHandshakeInterceptor)
        //        .setAllowedOrigins(allowedOrigins)
        //        .withSockJS();
    }

}
