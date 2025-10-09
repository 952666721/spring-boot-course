package top.qqs.boot.websocket;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@EnableScheduling
@SpringBootApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(WebSocketApplication.class, args);
    }
}