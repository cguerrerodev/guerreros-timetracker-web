package com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager;

import java.util.Set;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.dto.TagDTO;

public interface TagManager {

	Set<TagDTO> getByUserName(String userName);

}
