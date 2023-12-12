package centralregion.gatewayapi.config.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/adminApi-service/**")
                            .filters(f -> f.addRequestHeader( "adminApi-request",  "adminApi-request-header")
                                           .addResponseHeader("adminApi-response", "adminApi-response-header"))
                            .uri("http://localhost:9002"))
                .route(r -> r.path("/configApi-service/**")
                        .filters(f -> f.addRequestHeader( "configApi-request",  "configApi-request-header")
                                .addResponseHeader("configApi-response", "configApi-response-header"))
                        .uri("http://localhost:9003"))
                .build();
    }
}
