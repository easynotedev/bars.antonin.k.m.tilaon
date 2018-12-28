package com.accenture.tcf.bars.factory;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.accenture.tcf.bars.exception.BarsException;
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
		myWordFile = new File("unvalidatesupportedfiles.doc");
	}

	@After
	public void tearDown(){
		myTextFile = null;
		myXmlFile = null;
		myWordFile = null;
	}

	@Test
	public void testGetInstance(){
		assertTrue(InputFileFactory.getInstance() instanceof InputFileFactory);
	}

	@Test
	public void testGetInputFileTxt(){
		try {
			assertTrue(InputFileFactory.getInstance().getInputFile(myTextFile) instanceof TextInputFileImpl);
		} catch (BarsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetInputFileCsv(){
		try {
			assertTrue(InputFileFactory.getInstance().getInputFile(myXmlFile) instanceof CsvInputFileImpl);
		} catch (BarsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetNullInputFile()  {
		try {
			assertNull(InputFileFactory.getInstance().getInputFile(myWordFile));
		} catch (BarsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
