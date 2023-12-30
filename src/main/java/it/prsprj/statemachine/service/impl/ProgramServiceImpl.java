package it.prsprj.statemachine.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.prsprj.statemachine.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {

	private static final String PATH = "programs/";
	private static final String EXTENSION = "schema";
	
	@Override	
	public Optional<File> checkFileExists(String filename) {
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			File file = new File(classloader.getResource(PATH + filename + "." + EXTENSION).toURI());

			return file.exists() ? Optional.of(file) : Optional.empty();
		} catch(Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public int loadProgram(File f) {
		List<String> lines;
		
		try {
			lines = Files.readAllLines(f.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			
			return -1;
		}
		
		for(int i = 0; i < lines.size(); i++) {
			String pos[] = lines.get(i).split("\t");
			
			
		}
		
		return 0;
	}
}
