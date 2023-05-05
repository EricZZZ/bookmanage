package com.eric.bookmanage.config.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.eric.bookmanage.common.Response;

import cn.hutool.json.JSONUtil;

/**
 * 无权限访问的处理
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        Response result = Response.fail(accessDeniedException.getMessage());
        response.getOutputStream().write(JSONUtil.toJsonStr(result).getBytes(StandardCharsets.UTF_8));
    }

}
