package com.guerrerodev.timetracker.guerrerostimetrackerapi.service.exception;

public enum TimeTrackerExceptionCode {
	
	USER_NOT_FOUND("User not found"), 
	TAG_NOT_FOUND("Tag not found"), 
	START_TIME_MISSING("Start time missing"), 
	MINUTES_AND_PERIOD_DO_NOT_MATCH("Minutes and period do not match"), 
	NOT_STARTED_WORK_SESSION("Not started work session");
	

	TimeTrackerExceptionCode(String description){
		this.description = description;
	}
	
	private String description;
	
	public String getDescription() {
		return description;
	}

}
