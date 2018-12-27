package com.accenture.tcf.bars.factory;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import com.accenture.tcf.bars.file.CsvInputFileImpl;
import com.accenture.tcf.bars.file.IInputFile;
import com.accenture.tcf.bars.file.TextInputFileImpl;

public class InputFileFactory {

	private static InputFileFactory iff;

	public static InputFileFactory getInstance(){

		if (iff == null) {
			iff = new InputFileFactory();
		}

		return iff;
	}

	public static IInputFile getInputFile(File file){
		String filenameext = FilenameUtils.getExtension(file.getName());
		IInputFile inputfile = null;
		if(filenameext.equalsIgnoreCase("txt")){
			inputfile = new TextInputFileImpl();
		}else if(filenameext.equalsIgnoreCase("csv")){
			inputfile = new CsvInputFileImpl();
		}else{
			inputfile = null;
		}
		return inputfile;
	}

}
