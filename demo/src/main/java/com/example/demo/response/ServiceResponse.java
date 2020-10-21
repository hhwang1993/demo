package com.example.demo.response;

import java.io.Serializable;

public class ServiceResponse<T>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3280974696911485316L;

	private int status;
	 
    private String message;
 
    private String serviceId;
 
    private T data;
 
    public int getStatus() {
        return status;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getServiceId() {
        return serviceId;
    }
 
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
 
    public T getData() {
        return data;
    }
 
    public void setData(T data) {
        this.data = data;
    }

}