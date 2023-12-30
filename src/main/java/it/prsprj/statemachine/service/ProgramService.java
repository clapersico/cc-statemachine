package it.prsprj.statemachine.service;

import java.io.File;
import java.util.Optional;

public interface ProgramService {
	public Optional<File> checkFileExists(String file);
	public int loadProgram(File f);
}
