package com.guerrerodev.timetracker.guerrerostimetrackerapi.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.dto.TagDTO;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager.TagManager;


@RestController
@CrossOrigin("*")
public class TagController {
	
	@Autowired
	TagManager tagManager;
	
	@GetMapping(path = "users/{userName}/tags", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<TagDTO> getTags(@PathVariable String userName) {
		
		Set<TagDTO> result = null;
		
		try {
			
			result = tagManager.getByUserName(userName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
