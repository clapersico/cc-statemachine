package it.prsprj.statemachine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("machine")
public class MachineController {

	@GetMapping(value = "/register/{id}")
	public String register(@PathVariable int id) {
		return "KO";
	}
}
