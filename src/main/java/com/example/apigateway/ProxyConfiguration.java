package com.example.apigateway;


import com.example.apigateway.filters.ErrorFilter;
import com.example.apigateway.filters.PostFilter;
import com.example.apigateway.filters.Prefilter;
import com.example.apigateway.filters.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfiguration {

    @Bean
    public Prefilter preFilter() {
        return new Prefilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
