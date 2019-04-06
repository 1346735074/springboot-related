package com.rk.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rk.dataobject.User;
import org.springframework.stereotype.Service;

/**
 * Created by nuonuo
 * 2018/8/9 下午 5:43
 */
@Service
public class TokenService {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }


}
