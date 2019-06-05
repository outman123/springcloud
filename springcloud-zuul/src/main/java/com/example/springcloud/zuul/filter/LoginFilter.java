package com.example.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends ZuulFilter {
    //路由之前过滤
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(token==null){
            //非法访问时
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                //返回设置和内容
                HttpServletResponse response = currentContext.getResponse();
                response.setContentType("text/html;charset=UTF-8");
                currentContext.getResponse().getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
}
