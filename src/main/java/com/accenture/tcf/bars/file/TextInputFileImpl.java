package com.accenture.tcf.bars.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.accenture.tcf.bars.dao.RequestDAOImpl;
import com.accenture.tcf.bars.datasource.MySQLDatasource;
import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;

public class TextInputFileImpl extends AbstractInputFile {
	//static File myTextFile = new File("readvalidrequestparam.txt");

	static int ctr = 0;

	@SuppressWarnings("resource")
	@Override
	public List<Request> readFile() throws BarsException, IOException, ParseException, SQLSyntaxErrorException {
		// super.getFile() use later when Fileprocessor is implemented
		List<Request> listofreq = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = new FileReader(super.getFile());

		br = new BufferedReader(fr);
		String digits = null;
		Request req = new Request();
		ctr = 1;
		try {
			while ((digits = br.readLine()) != null) {
				if(digits.length()!=18)
					throw new BarsException(BarsException.INVALID_END_DATE_FORMAT + ctr);
				if(Integer.parseInt(digits.substring(0, 2)) <= 0 || Integer.parseInt(digits.substring(0, 2)) > 12)
			    	throw new BarsException(BarsException.BILLING_CYCLE_NOT_ON_RANGE + ctr);
			    if(Integer.parseInt(digits.substring(2, 4))< 1 || Integer.parseInt(digits.substring(2, 4))> 12 || Integer.parseInt(digits.substring(4, 6)) > 32)
			    	throw new BarsException(BarsException.INVALID_START_DATE_FORMAT + ctr);
			    if(Integer.parseInt(digits.substring(10, 12))<1 || Integer.parseInt(digits.substring(10, 12))>12 || Integer.parseInt(digits.substring(12, 14))>32)
			    	throw new BarsException(BarsException.INVALID_END_DATE_FORMAT + ctr);
				req = new Request(Integer.parseInt(digits.substring(0, 2)), new SimpleDateFormat("MMddyyyy").parse(digits.substring(2, 10)),
						new SimpleDateFormat("MMddyyyy").parse(digits.substring(10, 18)));
				new RequestDAOImpl(MySQLDatasource.getSessionFactory()).insertRequest(req);
			    listofreq.add(req);
			    ctr++;
			}
		 } 	catch (NumberFormatException e) {
				throw new NumberFormatException();
			} catch (SQLSyntaxErrorException e) {
				throw new SQLSyntaxErrorException();
			} catch (IOException e) {
				throw new IOException();
			} catch (BarsException e) {
				throw new BarsException(e.getMessage());
			} finally {
				fr.close();
				ctr = 0;
			}
			br.close();

		return listofreq;
	}
}
