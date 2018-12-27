package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;

public interface IInputFile {

	abstract List<Request> readFile() throws FileNotFoundException, BarsException, IOException, ParseException;

	abstract void setFile();

	abstract File getFile();

}
