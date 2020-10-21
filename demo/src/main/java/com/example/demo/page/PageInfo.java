package com.example.demo.page;

import java.io.Serializable;
import java.util.List;
 
public class PageInfo<T> implements Serializable {
 
    int pageNum;
 
    int pageSize;
 
    int startIndex;
 
    int endIndex;
 
    int totalRows;
    
    int totalPage; 
 
    List<T> dataList;
 
    public int getPageNum() {
        return pageNum;
    }
 
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
 
    public int getPageSize() {
        return pageSize;
    }
 
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
 
    public int getStartIndex() {
        return startIndex;
    }
 
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
 
    public int getEndIndex() {
        return endIndex;
    }
 
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
 
    public List<T> getDataList() {
        return dataList;
    }
 
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
 
    public int getTotalRows() {
        return totalRows;
    }
 
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
}