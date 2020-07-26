package com.guerrerodev.timetracker.api.presentation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guerrerodev.timetracker.api.business.dto.WorkSessionDTO;
import com.guerrerodev.timetracker.api.business.dto.WorkSessionsReportDTO;
import com.guerrerodev.timetracker.api.business.exception.TimeTrackerException;
import com.guerrerodev.timetracker.api.business.manager.WorkSessionManager;

@RestController
@CrossOrigin("*")
public class WorkSessionController {
	
	@Autowired
	WorkSessionManager workSessionManager;
	
	@GetMapping(path = "/users/{userName}/worksessions/report", produces = MediaType.APPLICATION_JSON_VALUE)
	public WorkSessionsReportDTO getWorkSessionsReport(
			@PathVariable String userName,
			@RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
			@RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
		
		return workSessionManager.getWorkSessionsReport(userName, from, to);
	}
	
	@PostMapping(path = "/users/{userName}/tags/{tagName}/worksession")
	public WorkSessionDTO createWorkSession(@PathVariable String userName,
									@PathVariable String tagName,
									@RequestBody WorkSessionDTO workSessionDTO) {
		
		WorkSessionDTO result = null;
		
		try {
			workSessionDTO.setUserName(userName);
			workSessionDTO.setTagName(tagName);
			result = workSessionManager.createWorkSession(workSessionDTO);
			
		} catch (TimeTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	@PutMapping(path = "/users/{userName}/worksession/cancel")
	public void cancelWorkSession(@PathVariable String userName,
									@RequestBody LocalDateTime endTime) {
				
		try {
			
			workSessionManager.cancelWorkSession(userName, endTime);
						
		} catch (TimeTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@PutMapping(path = "/users/{userName}/worksession/end")
	public void endWorkSession(@PathVariable String userName,
									@RequestBody LocalDateTime endTime) {
				
		try {
			
			workSessionManager.endWorkSession(userName, endTime);
						
		} catch (TimeTrackerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
