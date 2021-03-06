package com.luolei.novel.sys.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luolei.novel.sys.common.HttpResult;
import com.luolei.novel.sys.common.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截器验证token
        String token = request.getHeader("token");

        if(StringUtils.isEmpty(token)){
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            response.getWriter().print(JSONObject.toJSONString(HttpResult.fail("未登录，请重新登录！")));
            return false;
        }
        boolean verify = JwtUtil.verity(token);

        return verify;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
