package com.wyl.dict.security;

import cn.hutool.http.HttpStatus;
import cn.wyl.common.core.dto.SingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler
 *
 * @author wyl
 * @since 2022-01-07 09:33:32
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class CustomizeOAuth2AccessDeniedHandler extends OAuth2AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    /**
     * 授权拒绝处理
     *
     * @param request       request
     * @param response      response
     * @param authException authException
     */
    @Override
    @SneakyThrows
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) {
        log.info("授权失败，禁止访问 {}", request.getRequestURI());
        SingleResponse result = SingleResponse.buildFailure(String.valueOf(HttpStatus.HTTP_FORBIDDEN), "授权失败，禁止访问");
        response.setStatus(HttpStatus.HTTP_FORBIDDEN);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(result));
    }

}
