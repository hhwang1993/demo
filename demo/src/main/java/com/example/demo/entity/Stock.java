package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Stock  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2684703762049117313L;

	private Long id;

    private String stockName;

    private Integer stockNo;

    private Date updateTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getStockNo() {
        return stockNo;
    }

    public void setStockNo(Integer stockNo) {
        this.stockNo = stockNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}