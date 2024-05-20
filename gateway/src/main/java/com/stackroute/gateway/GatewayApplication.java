package com.stackroute.gateway;

import com.stackroute.gateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient

public class GatewayApplication{
	@Autowired
	AuthenticationFilter filter;


//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*")); // Replace with your allowed origins
//		configuration.setAllowedMethods(Arrays.asList("*")); // Allow all HTTP methods
//		configuration.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
//		configuration.setAllowCredentials(true); // Allow credentials (e.g., cookies)
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//
//		return source;
//	}
//
//	@Bean
//	public CorsFilter corsFilter() {
//		return new CorsFilter(corsConfigurationSource());
//	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

		return builder.routes()
				.route("authentication", r -> r.path("/authentication")
						.uri("lb://AUTHENTICATION"))
				.route("userservice", r -> r.path("/userprofile/**")
						.filters(f -> f.filter(filter))
						.uri("lb://USERPROFILE"))
				.route("covid", r -> r.path("/covid/**")
						.uri("lb://COVID"))
				.route("bookmarkservice", r -> r.path("/bookmark/**")
						.filters(f -> f.filter(filter))
						.uri("lb://BOOKMARKSERVICE"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
