package com.example.springjwt.springjwt;

public class Constant {

    public static final String SECRET = "secret"; //TODO: Better if secret key for JWT stored in database
    public static final String HEADER_STRING = "Authorization";

    public static final String GENERAL_ERROR = "X06";
    public static final String GENERAL_ERROR_DESC = "General Error";
    public static final String LOGIN_ERROR = "L01";
    public static final String LOGIN_ERROR_DESC = "User not found";
    public static final String LOGIN_ERROR_WRONG_CREDENTIALS = "L02";
    public static final String LOGIN_ERROR_WRONG_CREDENTIALS_DESC = "Wrong Username or Password";
    public static final String LOGIN_ERROR_WRONG_TOKEN = "L03";
    public static final String LOGIN_ERROR_WRONG_TOKEN_DESC = "Error parse token";
}
