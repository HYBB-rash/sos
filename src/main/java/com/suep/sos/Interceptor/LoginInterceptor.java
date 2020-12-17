package com.suep.sos.Interceptor;

import com.suep.sos.Entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated() || subject.isRemembered();
    }

    private boolean begingWith(String page, String[] requireAuthPages) {
        boolean result = false;
        for (String requireAuthPage : requireAuthPages) {
            if (StringUtils.startsWith(page, requireAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
