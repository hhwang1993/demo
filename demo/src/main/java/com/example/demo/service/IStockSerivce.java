package com.example.demo.service;

import com.example.demo.entity.Stock;
import com.example.demo.page.PageInfo;
import com.example.demo.response.ServiceResponse;

public interface IStockSerivce {
	
	ServiceResponse<PageInfo> selectAll(int pageNum,int pageSize);
	
	ServiceResponse<String> insert(Stock stock);
	
	ServiceResponse<String> update(Stock stock);
	
	ServiceResponse<String> delete(Long id);
        
}