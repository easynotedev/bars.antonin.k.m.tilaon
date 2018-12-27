package com.accenture.tcf.bars.factory;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.tcf.bars.file.CsvInputFileImpl;
import com.accenture.tcf.bars.file.TextInputFileImpl;

import junit.framework.TestCase;

public class InputFileFactoryTest extends TestCase {

	File myTextFile;
	File myXmlFile;
	File myWordFile;


	@Before
	public void setUp(){
		myTextFile = new File("validatesupportedfiles.txt");
		myXmlFile = new File("validatessupportedfiles.csv");
		myWordFile = new File("validatesunsupportedfiles.doc");
	}

	@After
	public void tearDown(){
		myTextFile = null;
		myXmlFile = null;
	}

	@Test
	public void testGetInstance(){
		assertTrue(InputFileFactory.getInstance() instanceof InputFileFactory);
	}

	@Test
	public void testGetInputFileTxt(){
		assertTrue(InputFileFactory.getInputFile(myTextFile) instanceof TextInputFileImpl);
	}

	@Test
	public void testGetInputFileCsv(){
		assertTrue(InputFileFactory.getInputFile(myXmlFile) instanceof CsvInputFileImpl);
	}

	@Test
	public void testGetNullInputFile(){
		assertNull(InputFileFactory.getInputFile (myWordFile));
	}


}
