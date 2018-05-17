package com.example.springjwt.springjwt.persistence.service;

import com.example.springjwt.springjwt.Constant;
import com.example.springjwt.springjwt.persistence.entity.User;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String userName, String passWord) throws Exception {
        User user = userRepository.findByUserName(userName);
        validateUserLogin(user, passWord);
        return  Jwts.builder()
                .setIssuer("SpringJWT")
                .setSubject("JWTExample")
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .claim("userName", user.getUserName())
                .claim("email", user.getEmail())
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(DateUtils.addHours(new Date(), 8))
                .signWith(SignatureAlgorithm.HS256, Constant.SECRET)
                .compact();
    }

    @Override
    public User whoAmI(String token) throws Exception {
        if(!token.isEmpty()){
            Jws<Claims> claimsJwt = Jwts.parser()
                    .setSigningKey(Constant.SECRET)
                    .parseClaimsJws(token);
            Claims claims = claimsJwt.getBody();
            User user = new User();
            user.setFirstName(claims.get("firstName").toString());
            user.setLastName(claims.get("lastName").toString());
            user.setUserName(claims.get("userName").toString());
            user.setEmail(claims.get("email").toString());
            return user;
        }else {
            throw new Exception(Constant.LOGIN_ERROR_WRONG_TOKEN.concat("-").concat(Constant.LOGIN_ERROR_WRONG_TOKEN_DESC)); //TODO: Using custom Exception to catch Error code & description
        }
    }

    @Override
    public User saveUser(User user) {
        //TODO: Need add data's validation
        //TODO: User's password must be encrypt
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    private void validateUserLogin(User user, String passWord) throws Exception {
        if(user == null){
            throw new Exception(Constant.LOGIN_ERROR.concat("-").concat(Constant.LOGIN_ERROR_DESC)); //TODO: Using custom Exception to catch Error code & description
        }else if (!user.getPassWord().equals(passWord)){
            throw new Exception(Constant.LOGIN_ERROR_WRONG_CREDENTIALS.concat("-").concat(Constant.LOGIN_ERROR_WRONG_CREDENTIALS_DESC)); //TODO: Using custom Exception to catch Error code & description
        }
    }
}
