package com.soft1851.springboot.jwt.interceptor;

import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhao
 * @className JwtInterceptor
 * @Description TODO
 * @Date 2020/4/15
 * @Version 1.0
 **/
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;

    /**
     * 前置处理，拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            throw new JwtException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else {
            //已经登录
            log.info("## token= {}", token);
            //鉴权
            if (!adminService.checkRole(JwtTokenUtil.getUserRole(token))) {
                log.info("### 用户权限不足 ###");
                throw new JwtException("用户权限不足", ResultCode.USER_NO_AUTH);
            } else {
                return true;
//                if (JwtTokenUtil.isExpiration(token)) {
//                    log.info("## Token 已过期 ###");
//                    throw new JwtException("token已过期", ResultCode.USER_CODE_TIMEOUT);
//                } else {
//                    //通过认证，放行到controller层
//                    return true;
//                }
            }
        }
    }
}

