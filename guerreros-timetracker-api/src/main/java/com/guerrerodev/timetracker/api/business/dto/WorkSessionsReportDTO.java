package com.guerrerodev.timetracker.api.business.dto;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class WorkSessionsReportDTO {
	
	private LocalDate from;
	
	private LocalDate to;
	
	private int totalWorkSessions;
	
	private int totalMinutes;
	
	private Map<String, WorkSessionsByTagDTO> tagWorkSessions;


	public Map<String, WorkSessionsByTagDTO> getTagWorkSessions() {
		return tagWorkSessions;
	}

	public void setTagWorkSessions(Map<String, WorkSessionsByTagDTO> tagWorkSessions) {
		this.tagWorkSessions = tagWorkSessions;
	}

	public int getTotalWorkSessions() {
		return totalWorkSessions;
	}

	public void setTotalWorkSessions(int totalWorkSessions) {
		this.totalWorkSessions = totalWorkSessions;
	}

	public int getTotalMinutes() {
		return totalMinutes;
	}

	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}
	
	
}
