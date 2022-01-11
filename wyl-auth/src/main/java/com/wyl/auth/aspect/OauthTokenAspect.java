package com.wyl.auth.aspect;

import cn.wyl.common.core.dto.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * oauth-token拦截器
 * 统一返回token格式
 *
 * @author wyl
 * @since 2022-01-07 09:11:39
 */
@Slf4j
@Component
@Aspect
public class OauthTokenAspect {

    /**
     * 改变token数据返回格式
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        ResponseEntity accessTokenResponse = (ResponseEntity) joinPoint.proceed();
        return new ResponseEntity(SingleResponse.of(accessTokenResponse.getBody()),
                accessTokenResponse.getHeaders(), accessTokenResponse.getStatusCode());
    }

}
