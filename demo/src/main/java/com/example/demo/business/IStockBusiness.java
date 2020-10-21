package com.example.demo.business;

import com.example.demo.entity.Stock;
import org.apache.ibatis.annotations.Param;
import java.util.List;

//@Repository
public interface IStockBusiness {
	
	List<Stock> selectAll(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
	
    int queryTotalRows();

	//  Stock selectByPrimaryKey(Long id);
	
	void insert(Stock stock) throws Exception;;
	  
	void update(Stock stock) throws Exception;;
	
	void delete(Long id) throws Exception;;
	  
}