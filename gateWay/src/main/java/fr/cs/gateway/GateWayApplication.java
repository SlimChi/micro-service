package fr.cs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builer){
        return builer.routes()
                .route(r->r.path("/users/**").uri("http://localhost:9090/"))
                .route(r->r.path("/mail/**").uri("http://localhost:9091/"))
                .build();
    }

}
