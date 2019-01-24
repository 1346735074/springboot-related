package com.demo.ant.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工单基础信息表
 * </p>
 *
 * @author zhaoyao
 * @since 2018-12-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("txp_workorder_cs")
public class WorkorderCs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 对应工单id
     */
    private Long workorderId;

    /**
     * 受理组id
     */
    private Long dealOrgId;

    /**
     * 受理组名称
     */
    private String dealOrgName;

    /**
     * 受理组的组长id
     */
    private Long dealLeaderId;

    /**
     * 受理组的组长姓名
     */
    private String dealLeaderName;

    /**
     * 受理组的组员id
     */
    private Long dealMemberId;

    /**
     * 受理组的组员姓名
     */
    private String dealMemberName;

    /**
     * 用户手机号
     */
    private String customerTel;

    /**
     * 用户淘宝id
     */
    private String customerId;

    /**
     * 工单一级分类id
     */
    private String typeOneLevelId;

    /**
     * 工单二级分类id
     */
    private String typeTwoLevelId;

    /**
     * 工单三级分类id
     */
    private String typeThreeLevelId;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 是否删除:y||n(小写)
     */
    private String isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 修改人id
     */
    private Long modifyId;

    /**
     * 修改人姓名
     */
    private String modifyName;

    /**
     * 扩展字段
     */
    private String attributes;

    /**
     * 隔离id
     */
    private Long sellerId;


}
