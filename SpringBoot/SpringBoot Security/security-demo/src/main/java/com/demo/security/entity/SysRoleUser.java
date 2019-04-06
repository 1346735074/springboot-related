package com.demo.security.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author YAO
 * @since 2018-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * user_id
     */
    private Integer sysUserId;

    /**
     * role_id
     */
    private Integer sysRoleId;


}
