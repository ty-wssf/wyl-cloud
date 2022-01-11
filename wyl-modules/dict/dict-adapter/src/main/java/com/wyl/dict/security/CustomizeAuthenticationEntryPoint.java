package com.wyl.dict.security;

import cn.wyl.common.core.dto.SingleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 客户端异常处理 1. 可以根据 AuthenticationException 不同细化异常处理
 *
 * @author wyl
 * @since 2022-01-07 10:17:22
 */
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
      /*  HashMap<String, String> map = new HashMap<>(2);
        map.put("uri", request.getRequestURI());
        map.put("msg", "认证失败");*/
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper objectMapper = new ObjectMapper();
        String resBody = objectMapper.writeValueAsString(SingleResponse.buildFailure(String.valueOf(HttpServletResponse.SC_UNAUTHORIZED), e.getMessage()));
        PrintWriter printWriter = response.getWriter();
        printWriter.print(resBody);
        printWriter.flush();
        printWriter.close();
    }

}
