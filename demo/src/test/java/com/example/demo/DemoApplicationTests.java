package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.entity.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Tutorial2Application.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Autowired
	ObjectMapper objectMapper;
	MockMvc mvc; //創建MockMvc類的物件
	
	Stock stock;
	@Before
	public void setup(){
		stock = new Stock();
		stock.setStockName("國泰");
		stock.setStockNo(9000);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void contextLoads() throws Exception {
		String uri = "/stock/insert";
		try{
			MvcResult result = mvc.perform(MockMvcRequestBuilders.post(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(stock))
					.accept(MediaType.APPLICATION_JSON))
					.andReturn();
				       
			int status = result.getResponse().getStatus();
			Assert.assertEquals("錯誤",200,status);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	


}
