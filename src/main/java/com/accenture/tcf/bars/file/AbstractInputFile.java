package com.accenture.tcf.bars.file;

import java.io.File;

public abstract class AbstractInputFile implements IInputFile {
	File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}



}
