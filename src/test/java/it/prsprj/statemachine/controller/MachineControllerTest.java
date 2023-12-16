package it.prsprj.statemachine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
@DisplayName("Machine Controller")
public class MachineControllerTest {

	@Autowired
	private MachineController machineController;
	
	private MockMvc mock;
	
	@BeforeEach
	void beforeEach() {
		this.mock = MockMvcBuilders.standaloneSetup(this.machineController).build();
	}
	
	@Test
	@DisplayName("Registrazione macchina ok")
	void testRegistrazioneMacchinaOk() throws Exception {
		this.mock.perform(get("/machine/register/0"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").value("OK"));
	}
}
