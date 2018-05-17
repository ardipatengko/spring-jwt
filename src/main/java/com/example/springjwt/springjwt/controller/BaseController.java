package com.example.springjwt.springjwt.controller;

import com.example.springjwt.springjwt.Constant;
import io.jsonwebtoken.Jwts;

public class BaseController {

    protected Boolean validateToken(String token) throws Exception {
        if(!token.isEmpty()){
            //Only check if token can be parsed. Doesn't check current user's role
            try {
                Jwts.parser()
                        .setSigningKey(Constant.SECRET)
                        .parseClaimsJws(token);
            }catch (Exception ex){
                return false;
            }
            return true;
        }
        return false;
    }

}
