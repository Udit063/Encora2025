package com;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.entity.Users;
import com.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	void setup() {
		userRepository.save(new Users(1L, "Udit"));
	}

	@Test
	void shouldReturnUserFromDatabase() throws Exception {
		mockMvc.perform(get("/users/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Udit"));
	}

	@Test
	void shouldReturnNotFoundForMissingUser() throws Exception {
		mockMvc.perform(get("/users/99")).andExpect(status().isNotFound());
	}
}
