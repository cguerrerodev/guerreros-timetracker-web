package com.guerrerodev.timetracker.api.business.manager.imp;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guerrerodev.timetracker.api.business.dto.TagDTO;
import com.guerrerodev.timetracker.api.business.manager.TagManager;
import com.guerrerodev.timetracker.api.persistence.entity.TagEntity;
import com.guerrerodev.timetracker.api.persistence.repository.TagRepository;

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
