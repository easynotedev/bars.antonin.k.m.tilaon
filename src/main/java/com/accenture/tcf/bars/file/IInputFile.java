package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.util.List;

import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;

public interface IInputFile {

	abstract List<Request> readFile() throws FileNotFoundException, BarsException, IOException, ParseException, SQLSyntaxErrorException;

	abstract void setFile(File file);

	abstract File getFile();

}
