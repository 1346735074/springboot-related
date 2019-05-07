package com.zto.dayun.dto.ent;

/**
 * @Auther: YAO
 * @Date: 2018/9/29 16:50
 * @Description:
 */
public class Signs {

    /** 运单号（运单号或子单号任填一个. */
    private String ewbNo;

    /** 签收人. */
    private String signMan;

    /** 签收类型0正常1异常. */
    private Integer signType;

    /** 扫描id. */
    private Long scanSourceId;

    /** 扫描设备编号. */
    private String deviceCode;

    /** 扫描时间： 满足格式：
     * 例如：“yyyy-MM-dd HH:mm:ss”. */
    private String signTime;



    //失败多余字段
    /** 异常签收类型. */
    private String slipTypeId;
    /** 图片信息. */
    private String images;

    private class Images{
        /** 图片名称（带尾缀）. */
        private String fileName;

        /** 字节流编码信息. */
        private String fileString;
    }
}
