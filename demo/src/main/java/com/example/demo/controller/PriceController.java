package com.example.demo.controller;

import com.example.demo.entity.Price;
import com.github.pagehelper.PageInfo;
import com.example.demo.service.IPriceSerivce;
import com.example.demo.service.impl.PriceService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value="/price")
public class PriceController {

 	@Autowired
    private IPriceSerivce priceSerivce;

 	private  static final Logger logger = LoggerFactory.getLogger(PriceService.class);
 	
	 	@RequestMapping(value="/page",method=RequestMethod.GET)
	    public ModelAndView page(Price price,
	                             @RequestParam(defaultValue = "1")int pageNumber,
	                             @RequestParam(defaultValue = "10")int pageSize){
	        ModelAndView modelAndView = new ModelAndView("index");  //定義一個視圖物件名字時index.html  首碼和尾碼都有封裝,只需要寫名字
	        PageInfo<Price> pageInfo = priceSerivce.page(price,pageNumber,pageSize);
	        modelAndView.addObject("pageInfo",pageInfo);   //相當於setAttriute("pageInfo",pageInfo)
	        modelAndView.addObject("price",price);
	        return modelAndView;
	    }
	 
	 	
	 	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST },
	 	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	 		public ModelAndView insert(Price price, @RequestParam(required=false) String tradePrice,
	 				@RequestParam(required=false) String quantity,
	 				@RequestParam(required=false) String stockId ){
        	ModelAndView modelAndView = new ModelAndView("insert"); 
        	List<Price> list = priceSerivce.selectStockNameForTrade();
	        PageInfo<Price> pageInfo = new PageInfo<>(list);
	        modelAndView.addObject("pageInfo",pageInfo);   
	        modelAndView.addObject("price",price);
	        try{
//	        	 Optional.ofNullable(tradePrice).orElseThrow(
//	        			 () -> new IllegalArgumentException("請填入 交易價格"));
//	        	 Optional.ofNullable(quantity).orElseThrow(
//	        			 () -> new IllegalArgumentException("請填入 交易量"));
//	        	 Optional.ofNullable(stockId).orElseThrow(
//	        			 () -> new IllegalArgumentException("請填入 股票名稱"));
	        	 price.setTradePrice(new BigDecimal(tradePrice) );
	        	 price.setQuantity(Long.parseLong(quantity));
	        	 price.setStockId(Long.parseLong(stockId));
	             this.priceSerivce.insert(price);
	        }catch (Exception e){
//	            e.printStackTrace();
	            logger.error("/insert failed: ", e);
	        }
	        return modelAndView;
	    }

	 	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	 	public ModelAndView update(Price price,
	 			@RequestParam(required=false) String updateID,
	 			@RequestParam(required=false) String updateQuantity) {
	 		try{
	 			price.setId(Long.parseLong(updateID));
	        	price.setQuantity(Long.parseLong(updateQuantity));
	        	price.setId(price.getId());
	        	priceSerivce.update(price);
		 	}catch (Exception e){
	            logger.error("/update failed: ", e);
	        }
            return new ModelAndView("redirect:/price/page");  
	 	}
	 	
	 	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	    public ModelAndView delete(Price price, @RequestParam(required=false) String deleteID) {
		        try{
		        	this.priceSerivce.delete(Long.parseLong(deleteID));
			 	}catch (Exception e){
		            logger.error("/delete failed: ", e);
		        }
	            return new ModelAndView("redirect:/price/page");  
	    }
	    
}

