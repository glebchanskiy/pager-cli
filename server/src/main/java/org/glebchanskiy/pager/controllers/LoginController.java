package org.glebchanskiy.pager.controllers;

import org.glebchanskiy.pager.services.UserDetailService;
import org.glebchanskiy.pager.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserDetailService userDetailService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public LoginController(UserDetailService userDetailService, JwtTokenUtil jwtTokenUtil) {
        this.userDetailService = userDetailService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        System.out.println(request);
        if (Objects.equals(
                userDetailService.loadUserByUsername(request.get("username")).getPassword(),
                request.get("password")))
            return ResponseEntity.of(Optional.of(Map.of(
                    "token",
                    jwtTokenUtil.generateToken(userDetailService.loadUserByUsername(request.get("username")))
            )));
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
