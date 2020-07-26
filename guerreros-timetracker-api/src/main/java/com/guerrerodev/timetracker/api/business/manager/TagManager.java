package com.guerrerodev.timetracker.api.business.manager;

import java.util.Set;

import com.guerrerodev.timetracker.api.business.dto.TagDTO;

public interface TagManager {

	Set<TagDTO> getByUserName(String userName);

}
