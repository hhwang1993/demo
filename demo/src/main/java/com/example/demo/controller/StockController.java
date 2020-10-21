package com.example.demo.controller;

import com.example.demo.entity.Stock;
import com.example.demo.page.PageInfo;
import com.example.demo.response.ServiceResponse;
import com.example.demo.service.IStockSerivce;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value="/stock")
public class StockController {

	    @Autowired
	    private IStockSerivce stockSerivce;

	    /**
	     * 分頁查詢
	     */
	    @RequestMapping(value="/page",method=RequestMethod.GET)
	    public ModelAndView   selectAll(Map<String, Object> map,
                @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                @RequestParam(defaultValue="10",value="pageSize")Integer pageSize){
	        //設置默認當前頁
	        if(pageNum==null || pageNum<=0){
	            pageNum = 1;
	        }
	        //設置預設每頁顯示的資料數
	        if(pageSize == null){
	            pageSize = 1;
	        }
	        PageHelper.startPage(pageNum,pageSize);
	        ServiceResponse<PageInfo> response = stockSerivce.selectAll(pageNum,pageSize);
            map.put("response", response);
	        return new ModelAndView("hello");
	    }

	    
	    @RequestMapping(value="/insert",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"},consumes = {"application/json"})
	    public ServiceResponse<String> insert(@RequestBody Stock stock){
	        return stockSerivce.insert(stock);
	    }
	 
	    @RequestMapping(value="/update",method = RequestMethod.POST)
	    public ServiceResponse<String> update(@RequestBody Stock stock){
	        return stockSerivce.update(stock);
	    }
	 
	    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	    public  ServiceResponse<String> deleteUserInfo(@RequestParam("id") Long id){
	        return stockSerivce.delete(id);
	    }
	 
	 


}
