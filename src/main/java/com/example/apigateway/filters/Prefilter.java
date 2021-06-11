package com.example.apigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


public class Prefilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();



        System.out.println("Request Method : " + request.getMethod()
                + " Request URL : " + request.getRequestURI().toString());
        // Alter ignored headers as per: https://gitter.im/spring-cloud/spring-cloud?at=56fea31f11ea211749c3ed22
        Set<String> headers = ctx.keySet();

        for (String s : headers){
            System.out.println(s);
        }
//        headers.remove("authorization");
        System.out.println("authorzation::"+headers.contains("Authorization"));
        return null;
    }
}
