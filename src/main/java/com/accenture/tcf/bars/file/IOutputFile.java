package com.accenture.tcf.bars.file;

import java.io.File;
import java.util.List;

public interface IOutputFile {
	abstract void writeFile(List records);

	abstract void setFile(File file);

	abstract File getFile();
}
