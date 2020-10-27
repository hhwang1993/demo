package com.example.demo.service.impl;

import com.example.demo.business.IStockBusiness;
import com.example.demo.dao.IPriceDao;
import com.example.demo.entity.Price;
import com.example.demo.entity.Stock;
import com.github.pagehelper.PageInfo;
import com.example.demo.response.ServiceResponse;
import com.example.demo.service.IPriceSerivce;
import com.example.demo.service.IStockSerivce;
import com.github.pagehelper.PageHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PriceService implements IPriceSerivce {
	
	 	@Autowired
	    private IPriceDao iPriceDao;
	 
	    private  static final Logger logger = LoggerFactory.getLogger(PriceService.class);

	    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	    public PageInfo<Price> page(Price price,int pageNumber,int pageSize){
	        PageHelper.startPage(pageNumber,pageSize);
	        List<Price> list = iPriceDao.selectByParamter(price);
	        PageInfo<Price> pageInfo = new PageInfo<>(list);
	        return pageInfo;
	    }
	    
	    @Override
	    public List<Price> selectStockNameForTrade() {
	        return this.iPriceDao.selectStockNameForTrade();
	    }

	    @Override
	    public void insert(Price price) {
	        this.iPriceDao.insert(price);
	    }

	     @Override
	    public void update(Price price) {
	        this.iPriceDao.update(price);
	    }

	    @Override
	    public void delete(Long id) {
	        this.iPriceDao.delete(id);
	    }
	    
	}