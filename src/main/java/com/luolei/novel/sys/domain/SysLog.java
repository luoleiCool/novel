package com.luolei.novel.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("sys_log")
@NoArgsConstructor
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 操作用户 */
    @TableField("user_name")
    private String userName;

    /** 描述 */
    @TableField("description")
    private String description;

    /** 方法名 */
    @TableField("method")
    private String method;

    /** 参数 */
    @TableField("params")
    private String params;


    /** 请求ip */
    @TableField("request_ip")
    private String requestIp;

    /** 地址 */
    @TableField("address")
    private String address;


    /** 请求耗时 */
    @TableField("time")
    private String time;


    /** 创建日期 */
    @TableField("create_time")
    private String createTime;




}
