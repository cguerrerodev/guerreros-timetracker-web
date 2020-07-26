package com.guerrerodev.timetracker.api.business.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import com.guerrerodev.timetracker.api.business.dto.WorkSessionDTO;
import com.guerrerodev.timetracker.api.business.dto.WorkSessionsReportDTO;
import com.guerrerodev.timetracker.api.business.exception.TimeTrackerException;

public interface WorkSessionManager {

	int getMinutesByUserAndTag(String userName, String tagName) throws TimeTrackerException;
	
	WorkSessionDTO createWorkSession(WorkSessionDTO workSessionDTO) throws TimeTrackerException;

	void cancelWorkSession(String userName, LocalDateTime endTime) throws TimeTrackerException;

	void endWorkSession(String userName, LocalDateTime endTime) throws TimeTrackerException;
	
	WorkSessionsReportDTO getWorkSessionsReport(String userName, LocalDate from, LocalDate to);
	
//	Map<String, Integer> getNumberOfSession(String userName, LocalDate from, LocalDate to);
}
