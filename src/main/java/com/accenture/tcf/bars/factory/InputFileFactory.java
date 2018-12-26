package com.accenture.tcf.bars.factory;

import com.accenture.tcf.bars.file.InputFile;

public class InputFileFactory {

	private static InputFileFactory iff;

	public static InputFileFactory getInstance(){

		if (iff == null) {
			iff = new InputFileFactory();
		}

		return iff;
	}


}
