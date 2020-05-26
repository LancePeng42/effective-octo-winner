package com.citic.payment.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 头像
     */
    private String icon;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 手机号，可作为登录名
     */
    private String phone;

    /**
     * 地址
     */
    private String addr;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色标识，0==》普通用户，1==》管理员
     */
    @Column(name = "role_code")
    private Integer roleCode;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 启用状态，0==》禁用，1==》启用
     */
    private Integer status;

    /**
     * 备用字段
     */
    private String reserve;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取头像
     *
     * @return icon - 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置头像
     *
     * @param icon 头像
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号，可作为登录名
     *
     * @return phone - 手机号，可作为登录名
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号，可作为登录名
     *
     * @param phone 手机号，可作为登录名
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取地址
     *
     * @return addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取角色标识，0==》普通用户，1==》管理员
     *
     * @return role_code - 角色标识，0==》普通用户，1==》管理员
     */
    public Integer getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色标识，0==》普通用户，1==》管理员
     *
     * @param roleCode 角色标识，0==》普通用户，1==》管理员
     */
    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取启用状态，0==》禁用，1==》启用
     *
     * @return status - 启用状态，0==》禁用，1==》启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置启用状态，0==》禁用，1==》启用
     *
     * @param status 启用状态，0==》禁用，1==》启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取备用字段
     *
     * @return reserve - 备用字段
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * 设置备用字段
     *
     * @param reserve 备用字段
     */
    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}