package com.csi.sbs.gateway;


import java.text.ParseException;

import com.csi.sbs.common.business.util.JwtTokenProviderUtil;

import io.jsonwebtoken.Claims;

/**
 * JWT-Token生成
 * 
 * @author Tony
 *
 */
public class JWTtests {
    public static void main(String[] args) throws ParseException {
        // md5("7981798723412342134"); > 签名
 
        // 密钥 12345678
        JwtTokenProviderUtil j = new JwtTokenProviderUtil("123456");
        
        // 生成Token
        Claims userClaims = j.parseToken("eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNo8zLsNwjAQBuBdrqawTcyRtFCAkLKD7ZxCJD8iEyMQYgbEFqzAQBRsgS0Q7fc_LtDRkWwYKW7X0IA0iGhQk1CVYRXn9VIj1hJmYELyUzyvQke5uNkVsqTi4PufMcZ4Vh2VN_u_FbKhH3yrXJHX_fF-3so6HabgKLbJaYrfLpsLZIsc0mmEhkspUIr8e_0AAAD__w.qQx8G0GvASmxNBn3o2bQyU8bzDldz4PYmXhWFQmJXjqUcTvejoYZefhIY8czPNMiVVY862Qw4IMuhTQeex2GgA");
       
//        Claims b = new UserClaims();
//        b
//        UserClaims a = (UserClaims)userClaims;
        System.out.println("解析出来的Toekn内容：" +  userClaims);
        System.out.println("动脑学院两周年，现在报名，给你想不到的优惠");

    }
}