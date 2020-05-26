package com.citic.payment.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_service_connect")
public class UserServiceConnect {
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
     * 本月使用量
     */
    private Integer used;

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
     * 保留字段
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
     * 获取本月使用量
     *
     * @return used - 本月使用量
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * 设置本月使用量
     *
     * @param used 本月使用量
     */
    public void setUsed(Integer used) {
        this.used = used;
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
     * 获取保留字段
     *
     * @return reserve - 保留字段
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * 设置保留字段
     *
     * @param reserve 保留字段
     */
    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}