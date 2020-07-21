package com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager.imp;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.entity.TagEntity;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.persistence.repository.TagRepository;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.dto.TagDTO;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager.TagManager;

@Service
public class TagManagerImp implements TagManager{


	@Autowired
	private TagRepository tagRepository;
	

	@Override
	public Set<TagDTO> getByUserName(String userName) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		Set<TagEntity> tagEntities = tagRepository.findByUserName(userName);
				
	    return modelMapper.map(tagEntities, new TypeToken<Set<TagDTO>>() {}.getType());
				

	}
	
}
