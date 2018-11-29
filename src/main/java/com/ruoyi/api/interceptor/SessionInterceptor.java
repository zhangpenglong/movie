package com.ruoyi.api.interceptor;

import com.ruoyi.api.annotation.IgnoreAuth;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.exception.ApiRRException;
import com.ruoyi.project.module.token.domain.Token;
import com.ruoyi.project.module.token.service.ITokenService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dongao on 2018/11/28.
 */

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private ITokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws  Exception{
        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        //如果有@IgnoreAuth注解，则不验证token
        if (annotation != null) {
            return true;
        }

        //从header中获取token
        String token = request.getHeader(Constants.LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(Constants.LOGIN_TOKEN_KEY);
        }

        //token为空
        if (StringUtils.isBlank(token)) {
            throw new ApiRRException("请先登录", 401);
        }

        //查询token信息
        Token tokenEntity = tokenService.queryByToken(token);
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new ApiRRException("token失效，请重新登录", 401);
        }
        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(Constants.LOGIN_USER_KEY, tokenEntity.getUserId());
        return true;
    }
}
