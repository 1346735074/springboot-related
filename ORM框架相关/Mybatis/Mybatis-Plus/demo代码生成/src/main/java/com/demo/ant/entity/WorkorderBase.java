package com.demo.ant.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("txp_workorder_base")
@ApiModel(value="WorkorderBase对象", description="工单基础信息表")
public class WorkorderBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工单模板")
    private String template;

    @ApiModelProperty(value = "业务id")
    private Long bizId;

    @ApiModelProperty(value = "咨询渠道")
    private String channel;

    @ApiModelProperty(value = "工单内容")
    private String content;

    @ApiModelProperty(value = "工单状态")
    private String status;

    @ApiModelProperty(value = "处理及时性")
    private String timely;

    @ApiModelProperty(value = "处理准确性")
    private String accuracy;

    @ApiModelProperty(value = "责任部门")
    private String responsibleDepartment;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "版本号")
    private Long version;

    @ApiModelProperty(value = "扩展字段")
    private String attributes;

    @ApiModelProperty(value = "是否删除:y||n(小写)")
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "创建人id")
    private Long createId;

    private String creator;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "修改人id")
    private Long modifyId;

    @ApiModelProperty(value = "隔离id")
    private Long sellerId;


}
