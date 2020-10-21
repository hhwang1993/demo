package com.example.demo.service.impl;

import com.example.demo.business.IStockBusiness;
import com.example.demo.entity.Stock;
import com.example.demo.page.PageInfo;
import com.example.demo.response.ServiceResponse;
import com.example.demo.service.IStockSerivce;
import com.github.pagehelper.PageHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService implements IStockSerivce {
	
	    @Autowired
	    private IStockBusiness stockBusiness;
	 
	    private  static final Logger logger = LoggerFactory.getLogger(StockService.class);

	    
	    @Override
	    public ServiceResponse<PageInfo> selectAll(int pageNum, int pageSize) {
	    	ServiceResponse<PageInfo> response = new ServiceResponse<>();
	        PageInfo pageInfo = new PageInfo();
	        pageInfo.setPageNum(pageNum);
	        pageInfo.setPageSize(pageSize);
	        int startIndex = (pageNum-1)*pageSize+1;
	        int endIndex = pageNum*pageSize;
	        pageInfo.setStartIndex(startIndex);
	        int totalRows = stockBusiness.queryTotalRows();
	        if(totalRows<endIndex){
	            endIndex = totalRows;
	        }
	        pageInfo.setEndIndex(endIndex);
	        pageInfo.setTotalRows(totalRows);
	        if(totalRows / pageSize ==0){
		        pageInfo.setTotalPage(1);
	        }else{
		        pageInfo.setTotalPage(totalRows / pageSize +1);
	        }
	        List<Stock> resultList = stockBusiness.selectAll(startIndex,pageSize-1);
	        pageInfo.setDataList(resultList);
	        response.setStatus(200);
	        response.setMessage("ok");
	        response.setData(pageInfo);
	        return response;
	    }
	
	    @Override
	    public ServiceResponse<String> insert(Stock stock) {
	        ServiceResponse<String> response = new ServiceResponse<>();
	        try{
	        	stockBusiness.insert(stock);
	            response.setMessage("ok");
	            response.setStatus(200);
	            response.setData("success");
	        }catch (Exception ex){
	            response.setMessage("inner service error:"+ex.getMessage());
	            response.setStatus(500);
	            response.setData("error");
	            logger.error(ex.getMessage(),ex);
	        }
	        return response;
	    }
	 
	    @Override
	    public ServiceResponse<String> update(Stock stock) {
	        ServiceResponse<String> response = new ServiceResponse<>();
	        try{
	        	stockBusiness.update(stock);
	            response.setMessage("ok");
	            response.setStatus(200);
	            response.setData("success");
	        }catch (Exception ex){
	            response.setMessage("inner service error:"+ex.getMessage());
	            response.setStatus(500);
	            response.setData("error");
	            logger.error(ex.getMessage(),ex);
	        }
	        return response;
	    }
	 
	    @Override
	    public ServiceResponse<String> delete(Long  id) {
	        ServiceResponse<String> response = new ServiceResponse<>();
	        try{
	        	stockBusiness.delete(id);
	            response.setStatus(200);
	            response.setMessage("ok");
	            response.setData("success!");
	        }catch(Exception ex){
	            response.setStatus(500);
	            response.setMessage("inner service error:"+ex.getMessage());
	            response.setData("error");
	            logger.error(ex.getMessage(),ex);
	        }
	        return response;
	    }
	 
	    
	}