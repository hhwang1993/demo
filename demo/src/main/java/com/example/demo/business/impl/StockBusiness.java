package com.example.demo.business.impl;

import com.example.demo.dao.IStockDao;
import com.example.demo.business.IStockBusiness;
import com.example.demo.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
@Component
public class StockBusiness implements IStockBusiness {
	
	    @Autowired
	    private IStockDao stockDao;
	    

	    @Override
	    public List<Stock> selectAll(int startIndex,int pageSize) {
	        //将分页参数传给PageHelper类的startPage（int pageNum,int pageSize）静态方法即可实现分页效果，非常简单
//	        PageHelper.startPage(pageNum,pageSize);
	        return stockDao.selectAll(startIndex,pageSize);
	    }
	 

	    @Override
	    public int queryTotalRows() {
	        return stockDao.queryTotalRows();
	    }
	    
	    @Override
	    @Transactional(rollbackFor = {Exception.class},readOnly = false)
	    public void insert(Stock stock) throws Exception {
	    	stockDao.insert(stock);
	    }
	 
	    @Override
	    @Transactional(rollbackFor = {Exception.class},readOnly = false)
	    public void update(Stock stock) throws Exception {
	    	stockDao.update(stock);
	    }
	 
	    @Override
	    @Transactional(rollbackFor = {Exception.class},readOnly = false)
	    public void delete(Long id) throws Exception {
	    	stockDao.delete(id);
	    }

	    
	}