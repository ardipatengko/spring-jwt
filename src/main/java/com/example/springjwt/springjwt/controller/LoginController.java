package com.example.springjwt.springjwt.controller;

import com.example.springjwt.springjwt.Constant;
import com.example.springjwt.springjwt.persistence.entity.User;
import com.example.springjwt.springjwt.persistence.service.UserService;
import com.example.springjwt.springjwt.utils.CommonResponse;
import com.example.springjwt.springjwt.utils.CommonUtils;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@EnableWebMvc
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Logger
    public String login(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(name = "userName") String userName,
                                    @RequestParam(name = "passWord") String passWord) throws Exception { //TODO: Using custom Exception to catch Error code & description
        String result = userService.login(userName, passWord);
        CommonResponse<String> res = CommonUtils.generateCommonResponse(result);
        response.setHeader(Constant.HEADER_STRING, result);
        //TODO: Need to set Session for current user login
        return CommonUtils.generateJson(res);
    }

    @PostMapping(value = "/whoAmI", produces = MediaType.APPLICATION_JSON_VALUE)
    @Logger
    public String getWhoAmI(HttpServletRequest request) throws Exception { //TODO: Using custom Exception to catch Error code & description
        String token = request.getHeader(Constant.HEADER_STRING);
        CommonResponse<User> res = CommonUtils.generateCommonResponse(userService.whoAmI(token));
        return CommonUtils.generateJson(res);
    }
}
