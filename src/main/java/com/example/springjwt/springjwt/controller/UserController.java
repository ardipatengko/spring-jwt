package com.example.springjwt.springjwt.controller;

import com.example.springjwt.springjwt.Constant;
import com.example.springjwt.springjwt.persistence.entity.User;
import com.example.springjwt.springjwt.persistence.service.UserService;
import com.example.springjwt.springjwt.utils.CommonResponse;
import com.example.springjwt.springjwt.utils.CommonUtils;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Logger
    public String saveUser(HttpServletRequest request, @RequestBody User user) throws Exception {
        String token = request.getHeader(Constant.HEADER_STRING);
        CommonResponse<User> res = new CommonResponse<>();
        if(validateToken(token)){
            res = CommonUtils.generateCommonResponse(userService.saveUser(user));
        }
        return CommonUtils.generateJson(res);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Logger
    public String getAllUser(HttpServletRequest request) throws Exception {
        String token = request.getHeader(Constant.HEADER_STRING);
        CommonResponse<List<User>> res = new CommonResponse<>();
        if(validateToken(token)){
            res = CommonUtils.generateCommonResponse(userService.getAllUser());
        }
        return  CommonUtils.generateJson(res);
    }
}
