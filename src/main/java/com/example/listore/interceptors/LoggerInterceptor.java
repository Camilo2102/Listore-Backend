package com.example.listore.interceptors;

import com.example.listore.utils.HttpUtils;
import com.example.listore.utils.LoggerUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI();
        String clientIP = HttpUtils.getRequestIP(request);
        String method = request.getMethod();

        int status = response.getStatus();


        LoggerUtil.petitionLog(url, method, String.valueOf(status), clientIP);
    }
}
