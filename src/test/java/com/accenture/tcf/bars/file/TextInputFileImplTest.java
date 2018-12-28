package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;
import com.accenture.tcf.bars.factory.InputFileFactory;

import junit.framework.TestCase;

public class TextInputFileImplTest extends TestCase {

	List<Request> listofreq;
	File myTextFile;
	InputFileFactory iff;

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws ParseException, BarsException {
		iff = InputFileFactory.getInstance();
	}

	@After
	public void tearDown(){
		listofreq = null;
		myTextFile = null;
	}

	@Test
	public void testReadTextValidRequestParameter() throws NumberFormatException, SQLSyntaxErrorException, IOException, ParseException, BarsException {
		ExpectedException.none();
//		File f = new File("C:\\BARS\\BillingAutomatedRequisitionSystem.antonin.k.m.tilaon\\deliverables\\test\\TextInputFileImplTest\\readvalidrequestparam.txt");
//		IInputFile inpf = iff.getInputFile(f);
//		inpf.setFile(f);
//		inpf.readFile();
//		assertEquals(inpf.readFile().size(), 1);
		new FileProcessor().execute(new File("C:\\BARS\\BillingAutomatedRequisitionSystem.antonin.k.m.tilaon\\deliverables\\test\\TextInputFileImplTest\\readvalidrequestparam.txt"));
	}

	@Test
	public void testReadTextInvalidBillingCycle() throws NumberFormatException, SQLSyntaxErrorException, IOException, ParseException, BarsException{
		thrown.expectMessage(BarsException.BILLING_CYCLE_NOT_ON_RANGE + "1");
		new FileProcessor().execute(new File("C:\\BARS\\BillingAutomatedRequisitionSystem.antonin.k.m.tilaon\\deliverables\\test\\TextInputFileImplTest\\invalidbillingcycle.txt"));
	}
}
