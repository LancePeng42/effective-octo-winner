package com.citic.payment.model;

import java.util.Date;
import javax.persistence.*;

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 缴费服务编号
     */
    @Column(name = "service_id")
    private Integer serviceId;

    /**
     * 用户-缴费服务-连接表编号
     */
    @Column(name = "user_service_connet_id")
    private Integer userServiceConnetId;

    /**
     * 所缴费服务使用量
     */
    private Integer used;

    /**
     * 支付方式编号
     */
    @Column(name = "pay_id")
    private Integer payId;

    /**
     * 费用
     */
    private Integer price;

    /**
     * 支付状态，0==》未缴费，1==》已缴费
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 通知日期
     */
    @Column(name = "notice_time")
    private Date noticeTime;

    /**
     * 缴费日期
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改日期
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取缴费服务编号
     *
     * @return service_id - 缴费服务编号
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * 设置缴费服务编号
     *
     * @param serviceId 缴费服务编号
     */
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * 获取用户-缴费服务-连接表编号
     *
     * @return user_service_connet_id - 用户-缴费服务-连接表编号
     */
    public Integer getUserServiceConnetId() {
        return userServiceConnetId;
    }

    /**
     * 设置用户-缴费服务-连接表编号
     *
     * @param userServiceConnetId 用户-缴费服务-连接表编号
     */
    public void setUserServiceConnetId(Integer userServiceConnetId) {
        this.userServiceConnetId = userServiceConnetId;
    }

    /**
     * 获取所缴费服务使用量
     *
     * @return used - 所缴费服务使用量
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * 设置所缴费服务使用量
     *
     * @param used 所缴费服务使用量
     */
    public void setUsed(Integer used) {
        this.used = used;
    }

    /**
     * 获取支付方式编号
     *
     * @return pay_id - 支付方式编号
     */
    public Integer getPayId() {
        return payId;
    }

    /**
     * 设置支付方式编号
     *
     * @param payId 支付方式编号
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    /**
     * 获取费用
     *
     * @return price - 费用
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置费用
     *
     * @param price 费用
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取支付状态，0==》未缴费，1==》已缴费
     *
     * @return pay_status - 支付状态，0==》未缴费，1==》已缴费
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态，0==》未缴费，1==》已缴费
     *
     * @param payStatus 支付状态，0==》未缴费，1==》已缴费
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取通知日期
     *
     * @return notice_time - 通知日期
     */
    public Date getNoticeTime() {
        return noticeTime;
    }

    /**
     * 设置通知日期
     *
     * @param noticeTime 通知日期
     */
    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    /**
     * 获取缴费日期
     *
     * @return pay_time - 缴费日期
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置缴费日期
     *
     * @param payTime 缴费日期
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改日期
     *
     * @return modify_time - 修改日期
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改日期
     *
     * @param modifyTime 修改日期
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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