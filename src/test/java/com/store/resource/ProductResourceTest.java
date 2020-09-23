package com.store.resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.store.StoreApplicationTests;
import com.store.resources.ProductResource;

public class ProductResourceTest extends StoreApplicationTests {

	private final String BASE_URL = "/products";
	
	private MockMvc mockMvc;

	@Autowired
	ProductResource productResource;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
	}

	@Test
	public void testGETProductResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPOSTSaveProduct() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
				.param("name", "ProdutoTeste1")
				.param( "price", "800.00"));
	}
}
