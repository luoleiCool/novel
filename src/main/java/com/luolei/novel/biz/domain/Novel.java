package com.luolei.novel.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
@TableName("novel")
public class Novel implements Serializable {


    private Integer id;
    /**
     * 小说名称
     */
    private String novelName;


    private String url;

    /**
     * 作者
     */
    private String author;


    /**
     * 说明简介
     */
    private String remark;





}
