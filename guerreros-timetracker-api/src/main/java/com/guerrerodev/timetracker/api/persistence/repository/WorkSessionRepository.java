package com.guerrerodev.timetracker.api.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.guerrerodev.timetracker.api.persistence.entity.WorkSessionEntity;

@Repository
public interface WorkSessionRepository extends CrudRepository<WorkSessionEntity, Long> {

	WorkSessionEntity findByUserNameAndStatusName(String userName, String statusName);
	
	List <WorkSessionEntity> findWorkSessionsByUserNameAndStartTime(String userName, LocalDate from);
	
}
