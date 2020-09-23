package com.store.resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.store.StoreApplicationTests;
import com.store.resources.OrderResource;

public class OrderResourceTest extends StoreApplicationTests{

	private final String BASE_URL = "/orders";
	
	private MockMvc mockMvc;

	@Autowired
	OrderResource orderResource;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(orderResource).build();
	}

	@Test
	public void testGETOrders() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
