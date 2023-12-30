package it.prsprj.statemachine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Program Controller")
public class ProgramControllerTest {

	@Autowired
	private ProgramController programController;
	
	private MockMvc mock;
	
	@BeforeEach
	void beforeEach() {
		this.mock = MockMvcBuilders.standaloneSetup(this.programController).build();
	}
	
	@Test
	@DisplayName("Avvio programma")
	void testAvvioProgramma() throws Exception {
		this.mock.perform(get("/program/start/cellula"))
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Avvio programma inesistente")
	void testAvvioProgrammaInesistente() throws Exception {
		this.mock.perform(get("/program/start/program-0"))
		.andExpect(status().isNotFound());
	}
}
