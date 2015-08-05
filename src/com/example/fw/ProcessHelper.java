package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends BaseHelper {

	private Process process;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public void startProcess() throws IOException {
		process = Runtime.getRuntime().exec(manager.getProperties("application"));
	}
	
	public void stopProcess() {
		process.destroy();
	}

}
