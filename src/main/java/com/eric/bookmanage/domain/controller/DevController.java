package com.eric.bookmanage.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.bookmanage.common.Response;
import com.eric.bookmanage.common.tools.JwtUtils;

@RestController
public class DevController {

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/testAuth")
    public Response testAuth() {
        System.out.println(jwtUtils.getHeader());
        System.out.println(jwtUtils.generateToken("eric"));
        return Response.success("auth success");
    }

    @GetMapping("/privateAuth")
    public Response privateAuth() {
        return Response.success("auth private success");
    }

}
