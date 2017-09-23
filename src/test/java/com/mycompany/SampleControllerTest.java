package com.mycompany;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private SecurityProperties securityProperties;

	@Test
	public void testHello_nonRedirection() throws Exception {
		if (securityProperties.isRequireSsl()) {
			return;
		}

		String user = "Preetam";
		mvc.perform(MockMvcRequestBuilders.get("/hello?user=" + user)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello " + user + " !")));
	}

	@Test
	public void testHello_nonRedirectionAgain() throws Exception {
		if (securityProperties.isRequireSsl()) {
			return;
		}
		mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello Spring Boot !")));
	}

	@Test
	public void testHello_Redirection() throws Exception {
		String user = "Palwe";
		mvc.perform(MockMvcRequestBuilders.get("/hello?user=" + user)).andExpect(status().is3xxRedirection());

	}

}
