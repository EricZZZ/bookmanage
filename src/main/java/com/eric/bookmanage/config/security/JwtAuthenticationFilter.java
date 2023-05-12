package com.eric.bookmanage.config.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.eric.bookmanage.common.tools.JwtUtils;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final String jwt = request.getHeader(jwtUtils.getHeader());
        if (StrUtil.isBlankOrUndefined(jwt)) {
            chain.doFilter(request, response);
            return;
        }
        Claims claims = jwtUtils.getClaimsByToken(jwt);
        if (claims == null) {
            chain.doFilter(request, response);
            return;
        }
        if (jwtUtils.isTokenExpired(claims)) {
            chain.doFilter(request, response);
            return;
        }
        String username = claims.getSubject();
        // 获取用户，权限等信息
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null,
                new ArrayList<>());
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 传入security上下文中，方便获取
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }

}
