package com.citic.payment.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_method")
public class PayMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 卡号或相应编号
     */
    @Column(name = "pay_code")
    private String payCode;

    /**
     * 缴费方式名称(例，中信银行，支付宝）
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 用户表编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     *  自动扣款，0==》未开启，1==》开启

     */
    private Integer auto;

    /**
     * 预留手机号
     */
    private String phone;

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
     * 获取卡号或相应编号
     *
     * @return pay_code - 卡号或相应编号
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * 设置卡号或相应编号
     *
     * @param payCode 卡号或相应编号
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    /**
     * 获取缴费方式名称(例，中信银行，支付宝）
     *
     * @return bank_name - 缴费方式名称(例，中信银行，支付宝）
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置缴费方式名称(例，中信银行，支付宝）
     *
     * @param bankName 缴费方式名称(例，中信银行，支付宝）
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取用户表编号
     *
     * @return user_id - 用户表编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户表编号
     *
     * @param userId 用户表编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取 自动扣款，0==》未开启，1==》开启

     *
     * @return auto -  自动扣款，0==》未开启，1==》开启

     */
    public Integer getAuto() {
        return auto;
    }

    /**
     * 设置 自动扣款，0==》未开启，1==》开启

     *
     * @param auto  自动扣款，0==》未开启，1==》开启

     */
    public void setAuto(Integer auto) {
        this.auto = auto;
    }

    /**
     * 获取预留手机号
     *
     * @return phone - 预留手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置预留手机号
     *
     * @param phone 预留手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
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