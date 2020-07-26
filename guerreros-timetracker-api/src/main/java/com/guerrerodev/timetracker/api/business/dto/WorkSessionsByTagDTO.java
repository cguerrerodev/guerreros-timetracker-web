package com.guerrerodev.timetracker.api.business.dto;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class WorkSessionsByTagDTO {
		
	private int totalWorkSessions;
	
	private int totalMinutes;

	private TagDTO tagDto;
	
	private Set<WorkSessionDTO> workSessions;

	

	public TagDTO getTagDto() {
		return tagDto;
	}

	public void setTagDto(TagDTO tagDto) {
		this.tagDto = tagDto;
	}




	public Set<WorkSessionDTO> getWorkSessions() {
		return workSessions;
	}

	public void setWorkSessions(Set<WorkSessionDTO> workSessions) {
		this.workSessions = workSessions;
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

	
}
