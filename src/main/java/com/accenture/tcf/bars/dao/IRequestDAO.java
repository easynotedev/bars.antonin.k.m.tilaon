package com.accenture.tcf.bars.dao;

import java.sql.SQLSyntaxErrorException;

import com.accenture.tcf.bars.domain.Request;

public interface IRequestDAO {
	public void insertRequest(Request request) throws SQLSyntaxErrorException;
	public void deleteRequest();
}
