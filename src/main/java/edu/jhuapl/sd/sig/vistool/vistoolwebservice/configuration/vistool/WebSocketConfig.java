package edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.vistool;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.vistool.WebSocketTopic.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  /**
   * Configure message broker
   * @param config
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker(TOPIC_ENDPOINT.value());  // send messages to clients with /topic prefix
    config.setApplicationDestinationPrefixes(API_ENDPOINT.value()); // used for REST endpoints that are annotated with @MessageMapping
  }

  /**
   * Register endpoint for websocket connections.
   * Use this endpoint to connect client to websocket message broker.
   *
   * Use withSockJS() when using sock/stompjs.
   * Comment out withSockJS() when using rxjs-stomp
   * @param registry
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint(SOCKET_ENDPOINT.value())
            .setAllowedOriginPatterns("*")
//            .withSockJS()
    ;
  }

}
