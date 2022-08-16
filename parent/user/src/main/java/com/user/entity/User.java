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
@TableName("user")
public class User implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 出生日期
     */
    private Date birth;

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
     * 注册时间
     */
    private Date createTime;

    /**
     * 上一次更改时间
     */
    private Date updateTime;

    /**
     * 兴趣爱好
     */
    private String hobby;

    /**
     * 用户真实姓名
     */
    private String userFullname;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 邮箱
     */
    private String eMail;
}
