package com.muyi.mastercard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MastercardApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testForYes() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/connected")
				.param("origin", "Newark")
				.param("destination", "Boston"))
				.andExpect(status().isOk())
				.andExpect(content().string("yes"));

	}

	@Test
	public void testForNo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/connected")
				.param("origin", "Newark")
				.param("destination", "Duluth"))
				.andExpect(status().isOk())
				.andExpect(content().string("no"));

	}

}
