package com.accenture.tcf.bars.file;

import java.io.File;
import java.util.List;

public interface InputFile {

	abstract List readFile();

	abstract void setFile();

	abstract File getFile();

}
