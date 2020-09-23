package com.store.resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.store.StoreApplicationTests;

import com.store.resources.ClientResource;

public class ClientResourceTest extends StoreApplicationTests {

    private final String BASE_URL = "/clients";
    
	private MockMvc mockMvc;

	@Autowired
	ClientResource clientResource;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(clientResource).build();
	}

	@Test
	public void testGETClientResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGETByIdClientResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL+"/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
