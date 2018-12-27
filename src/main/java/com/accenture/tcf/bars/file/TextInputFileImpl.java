package com.accenture.tcf.bars.file;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;

public class TextInputFileImpl extends AbstractInputFile {
	//static File myTextFile = new File("readvalidrequestparam.txt");
	static String digits = null;
	static Request req = new Request();

	public List<Request> readFile() throws BarsException, IOException, ParseException {
		// super.getFile() use later when Fileprocessor is implemented
		List<Request> listofreq = new ArrayList<>();

        Scanner s = new Scanner(super.getFile());

        while (s.hasNext()){
             digits = s.nextLine();
          }
          s.close();
         String ss = digits.substring(0, 2);
         int billingcycle = Integer.parseInt(ss);
         req.setBillingCycle(billingcycle);
         String startmonth = digits.substring(2, 4);
         String startday = digits.substring(4, 6);
         String startyear = digits.substring(6, 10);
         String billdate1 = startyear + "-" + startmonth + "-" + startday;
         String endmonth = digits.substring(10, 12);
         String endday = digits.substring(12, 14);
         String endyear = digits.substring(14, 18);
         String billdate2 = endyear + "-" + endmonth + "-" + endday;
         Date firsthalf, secondhalf;
			firsthalf = new SimpleDateFormat("yyyy-MM-dd").parse(billdate1);
			secondhalf = new SimpleDateFormat("yyyy-MM-dd").parse(billdate2);
			Request req = new Request(billingcycle, firsthalf, secondhalf);
			listofreq.add(req);
		return listofreq;
	}

	@Override
	public void setFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
