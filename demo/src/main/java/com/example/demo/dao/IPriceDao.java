package com.example.demo.dao;

import com.example.demo.entity.Price;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.aspectj.apache.bcel.util.Play;

public interface IPriceDao {
    
    List<Price> selectByParamter(Price price);

    List<Price> selectStockNameForTrade();

    int queryTotalRows();

    void insert(Price price);
    
    void update(Price price);

    void delete(Long id);
    
}