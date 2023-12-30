package it.prsprj.statemachine.controller;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prsprj.statemachine.exception.ProgramNotFoundException;
import it.prsprj.statemachine.service.ProgramService;

@RestController
@RequestMapping("program")
public class ProgramController {

	@Autowired
	private ProgramService programService;
	
	@GetMapping("/start/{pgm}")
	public String start(@PathVariable String pgm) {
		Optional<File> fileOpt = this.programService.checkFileExists(pgm);
		
		if(fileOpt.isEmpty())
			throw new ProgramNotFoundException();
		
		this.programService.loadProgram(fileOpt.get());
		
		return pgm;
	}
}
