package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;

import junit.framework.TestCase;

public class TextInputFileImplTest extends TestCase {

	List<Request> listofreq;
	TextInputFileImpl tifi;
	File myTextFile;

	@Before
	public void setUp() throws ParseException, BarsException {
		listofreq = new ArrayList<>();
		String billdate1 = "2013-01-01";
		String billdate2 = "2013-01-31";
		Date firsthalf, secondhalf;
			firsthalf = new SimpleDateFormat("yyyy-MM-dd").parse(billdate1);
			secondhalf = new SimpleDateFormat("yyyy-MM-dd").parse(billdate2);
			Request req = new Request(1, firsthalf, secondhalf);
			listofreq.add(req);
			tifi = new TextInputFileImpl();
			myTextFile = new File("src/test/java/com/accenture/tcf/bars/file/readvalidrequestparam.txt");
	}

	@After
	public void tearDown(){
		listofreq = null;
		myTextFile = null;
		tifi = null;
	}

	@Test
	public void testReadTextValidRequestParameter(){

		tifi.setFile(myTextFile);
		List<Request> lor;
		try {
			lor = tifi.readFile();
			assertEquals(listofreq.toString(), lor.toString());
		} catch (BarsException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
