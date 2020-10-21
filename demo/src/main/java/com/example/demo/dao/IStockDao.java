package com.example.demo.dao;

import com.example.demo.entity.Stock;
import org.apache.ibatis.annotations.Param;
import java.util.List;

//@Repository
public interface IStockDao {
	
    List<Stock> selectAll(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    int queryTotalRows();

//    Stock selectByPrimaryKey(Long id);

    void insert(Stock stock);
    
    void update(Stock stock);

    void delete(Long id);
    
}