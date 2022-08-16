package com.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wu_yr
 * @since 2022-07-08
 */
@Data
@TableName("authorities")
public class Authorities implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 权限名称
     */
    private String authoritiesName;

    /**
     * 版本
     */
    @Version
    private String version;

    /**
     * 删除标志位
     */
    private String isDelete;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 上一次更新人
     */
    private String updateBy;

    /**
     * 上一次更新时间
     */
    private Date updateDate;

}
