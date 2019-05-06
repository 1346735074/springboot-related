package com.rk.dataobject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nuonuo
 * 2018/8/9 下午 4:48
 */
@Data
@AllArgsConstructor //会生成一个包含所有变量
@NoArgsConstructor //生成一个无参数的构造方法
public class User {
    String Id;
    String username;
    String password;
}
