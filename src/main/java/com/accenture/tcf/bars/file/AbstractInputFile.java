package com.accenture.tcf.bars.file;

import java.io.File;

public abstract class AbstractInputFile implements IInputFile {
	private File file;

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public void setFile(File file) {
		this.file = file;
	}
}
