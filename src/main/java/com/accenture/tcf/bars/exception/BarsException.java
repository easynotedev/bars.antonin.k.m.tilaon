package com.accenture.tcf.bars.exception;

public class BarsException {

	public String INVALID_START_DATE_FORMAT(){
		return null;
	}

	public String INVALID_END_DATE_FORMAT(){
		return null;
	}

	public String BILLING_CYCLE_NOT_ON_RANGE(){
		return null;
	}

	public String PATH_DOES_NOT_EXIST(){
		return null;
	}

	public String NO_SUPPORTED_FILE(){
		return null;
	}

	public String NO_RECORDS_TO_READ(){
		return null;
	}

	public String NO_RECORDS_TO_WRITE(){
		return null;
	}

	public BarsException(String message){

	}

	public BarsException(String message, Throwable cause){

	}
}
