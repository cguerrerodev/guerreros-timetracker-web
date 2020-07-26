package com.guerrerodev.timetracker.api.business.dto;

import java.time.LocalDateTime;

public class WorkSessionDTO {
	
	private long id;
	private String tagName; 
	private String userName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String timePeriodStatusName;
	private long minutes;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getTimePeriodStatusName() {
		return timePeriodStatusName;
	}
	public void setTimePeriodStatusName(String timePeriodStatusName) {
		this.timePeriodStatusName = timePeriodStatusName;
	}
	public long getMinutes() {
		return minutes;
	}
	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	

	
}
