package com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.dto.WorkSessionDTO;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.exception.TimeTrackerException;

public interface WorkSessionManager {

	int getMinutesByUserAndTag(String userName, String tagName) throws TimeTrackerException;
	
	WorkSessionDTO createWorkSession(WorkSessionDTO workSessionDTO) throws TimeTrackerException;

	void cancelWorkSession(String userName, LocalDateTime endTime) throws TimeTrackerException;

	void endWorkSession(String userName, LocalDateTime endTime) throws TimeTrackerException;
	
	Map<String, Integer> getNumberOfSession(String userName, LocalDate from, LocalDate to);
}
