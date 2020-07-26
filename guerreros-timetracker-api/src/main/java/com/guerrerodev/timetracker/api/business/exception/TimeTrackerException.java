package com.guerrerodev.timetracker.api.business.exception;

public class TimeTrackerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	

	public TimeTrackerException(TimeTrackerExceptionCode timeTrackerExceptionCode) {
		super(timeTrackerExceptionCode.getDescription());
		this.code = timeTrackerExceptionCode.name();
	}	
	
	public String getCode() {
		return code;
	}
	
}
