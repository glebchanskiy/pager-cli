package org.glebchanskiy.pager.controllers;

import org.glebchanskiy.pager.services.UserDetailService;
import org.glebchanskiy.pager.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailService userDetailService;

    @Autowired
    public TokenController(JwtTokenUtil jwtTokenUtil, UserDetailService userDetailService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailService = userDetailService;
    }

    @GetMapping()
    public Map<String, String> getToken() {
        System.out.println(userDetailService.loadUserByUsername("gleb"));

//        return Map.of();
        return Map.of(
                "token",
                jwtTokenUtil.generateToken(userDetailService.loadUserByUsername("gleb"))
        );
    }
}
