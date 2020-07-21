package com.guerrerodev.timetracker.guerrerostimetrackerapi.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.dto.WorkSessionDTO;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.exception.TimeTrackerException;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager.WorkSessionManager;

@RestController
@CrossOrigin("*")
public class WorkSessionController {
	
	@Autowired
	WorkSessionManager workSessionManager;

	@PostMapping(path = "/users/{userName}/tags/worksession")
	public Map <String, Integer> getNumberOfSessionByDay(
			@PathVariable String userName,
			@RequestParam LocalDate from,
			@RequestParam LocalDate to) {
		
		return workSessionManager.getNumberOfSession(userName, from, to);
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
