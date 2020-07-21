package com.guerrerodev.timetracker.guerrerostimetrackerapi.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByName(String name);
	
}
