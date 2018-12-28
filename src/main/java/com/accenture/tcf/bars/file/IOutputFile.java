package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.accenture.tcf.bars.domain.Record;
import com.accenture.tcf.bars.exception.BarsException;

public interface IOutputFile {

	void writeFile(List<Record> records) throws BarsException, IOException;

	abstract void setFile(File file);

	abstract File getFile();


}
