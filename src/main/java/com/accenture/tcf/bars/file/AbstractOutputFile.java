package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.accenture.tcf.bars.domain.Record;
import com.accenture.tcf.bars.exception.BarsException;

public abstract class AbstractOutputFile implements IOutputFile {
	private File file;
	private static final Logger logger = Logger.getLogger(AbstractOutputFile.class);


	@Override
	public void writeFile(List<Record> records) throws BarsException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFile(File file) {
		file=this.file;
	}

	@Override
	public File getFile() {
		return this.file;
	}
}
