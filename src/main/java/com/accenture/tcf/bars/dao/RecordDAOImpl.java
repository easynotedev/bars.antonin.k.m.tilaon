package com.accenture.tcf.bars.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.accenture.tcf.bars.domain.Record;

public class RecordDAOImpl implements IRecordDAO{
	private SessionFactory sessionFactory;

	public RecordDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Record> retrieveRecords() {
		List<Record> records = new ArrayList<Record>();
		Session session = sessionFactory.openSession();
		List<Object[]> results = session.createSQLQuery("SELECT * FROM bars_db.billing").list();
    	String firstName = "", lastName = "";
    	int customerId = 0, billingCycle = 0;
    	BigDecimal amount = new BigDecimal(0);
    	Date startDate = new Date();
    	Date endDate = new Date();
    	for (Iterator<Object[]> iter = results.iterator(); iter.hasNext();) {
		    Object[] objs = iter.next();
		    for(int x=0;x<objs.length;x++) {
		    	billingCycle = (Integer) objs[1];
		    	amount = (BigDecimal) objs[3];
		    	startDate = (Date) objs[4];
		    	endDate = (Date) objs[5];
			    customerId = (int) objs[7];
		    }
		    List<Object[]> results2 = session.createSQLQuery("SELECT * FROM bars_db.customer WHERE customer_id='"+customerId+"'").list();
			for (Iterator<Object[]> iter2 = results2.iterator(); iter2.hasNext(); ) {
			    Object[] objs2 = iter2.next();
			    firstName = (String) objs2[1];
			    lastName = (String) objs2[2];
			}
		    if(!firstName.equals("")||!lastName.equals("")||Double.compare(amount.doubleValue(),0)==0)
				records.add(new Record(billingCycle,startDate,endDate,firstName + " " + lastName,firstName,lastName,amount.doubleValue()));
		}
    	session.close();
		return records;
	}


}
