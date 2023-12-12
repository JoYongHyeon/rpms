package centralregion.gatewayapi.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.NameConfig> {

    public CustomFilter() {
        super(NameConfig.class);
    }

    public static class NameConfig {

    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return ((exchange, chain) -> {
            // Custom Pre Filter  먼저 작업될 필터
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();


            log.info("Custom PRE filter: request uri -> {}", request.getId());

            // Custom Post Filter 후에 작업될 필터
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Custom POST filter: response code -> {}", response.getStatusCode());
            }));
        });
    }
}
