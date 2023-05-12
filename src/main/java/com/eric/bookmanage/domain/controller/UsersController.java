package com.eric.bookmanage.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.bookmanage.common.Response;
import com.eric.bookmanage.common.tools.JwtUtils;
import com.eric.bookmanage.domain.dto.LoginRequestDTO;
import com.eric.bookmanage.domain.service.IUsersService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author EricZhao
 * @since 2023-04-25
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public Response login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        authenticationManager.authenticate(token);
        String jwt = jwtUtils.generateToken(loginRequestDTO.getUsername());
        return Response.success(jwt);
    }

}
