package com.cy.cyshopspringboot.domain;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
    /**
     * 管理员id
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 管理员账号
     */
    @Column(name = "`user_account`")
    private String userAccount;

    /**
     * 管理员密码
     */
    @Column(name = "`user_password`")
    private String userPassword;

    /**
     * 管理员状态，1为已激活，2为未激活
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 角色id
     */
    @Column(name = "`role_id`")
    private Integer roleId;

    /**
     * 管理员备注
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 获取管理员id
     *
     * @return id - 管理员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理员id
     *
     * @param id 管理员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员账号
     *
     * @return user_account - 管理员账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置管理员账号
     *
     * @param userAccount 管理员账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取管理员密码
     *
     * @return user_password - 管理员密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置管理员密码
     *
     * @param userPassword 管理员密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取管理员状态，1为已激活，2为未激活
     *
     * @return status - 管理员状态，1为已激活，2为未激活
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置管理员状态，1为已激活，2为未激活
     *
     * @param status 管理员状态，1为已激活，2为未激活
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取管理员备注
     *
     * @return desc - 管理员备注
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置管理员备注
     *
     * @param desc 管理员备注
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}