package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Price;
import com.example.demo.entity.Stock;
import com.github.pagehelper.PageInfo;
import com.example.demo.response.ServiceResponse;

public interface IPriceSerivce {
	
	PageInfo page(Price price, int pageNumber, int pageSize);

    List<Price> selectStockNameForTrade();

    public void insert(Price price) ;

    public void update(Price price) ;

    public void delete(Long id) ;
        
}