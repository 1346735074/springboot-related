package com.demo.ant.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.demo.ant.entity.enums.AgeEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author YAO
 * @since 2018-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
//    private Integer age;
    private AgeEnum age;

    /**
     * 邮箱
     */
    private String email;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
