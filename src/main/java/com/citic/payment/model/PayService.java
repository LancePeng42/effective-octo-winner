package com.citic.payment.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pay_service")
public class PayService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 缴费项目名称
     */
    private String name;

    /**
     * 单位
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 单价，以分为单位
     */
    @Column(name = "unit_price")
    private Integer unitPrice;

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
     * 启用状态，0==》未启用，1==》启用
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
     * 获取缴费项目名称
     *
     * @return name - 缴费项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置缴费项目名称
     *
     * @param name 缴费项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取单位
     *
     * @return unit_name - 单位
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位
     *
     * @param unitName 单位
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取单价，以分为单位
     *
     * @return unit_price - 单价，以分为单位
     */
    public Integer getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单价，以分为单位
     *
     * @param unitPrice 单价，以分为单位
     */
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
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
     * 获取启用状态，0==》未启用，1==》启用
     *
     * @return status - 启用状态，0==》未启用，1==》启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置启用状态，0==》未启用，1==》启用
     *
     * @param status 启用状态，0==》未启用，1==》启用
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