package com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager.imp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guerrerodev.timetracker.guerrerostimetrackerapi.entity.TagEntity;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.entity.UserEntity;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.entity.WorkSessionEntity;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.persistence.repository.TagRepository;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.persistence.repository.UserRepository;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.persistence.repository.WorkSessionRepository;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.dto.WorkSessionDTO;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.exception.TimeTrackerException;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.exception.TimeTrackerExceptionCode;
import com.guerrerodev.timetracker.guerrerostimetrackerapi.service.manager.WorkSessionManager;

@Service
public class WorkSessionManagerImp implements WorkSessionManager{

	@Autowired
	private WorkSessionRepository workSessionRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static enum Status{
		
		STARTED(1), ENDED(2), CANCELED(3);
		
		private int id;
				
		private Status(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
	}
	

	
	@Override
	public WorkSessionDTO createWorkSession(WorkSessionDTO workSessionDTO) throws TimeTrackerException {
		
		try {
			
			if (workSessionDTO.getStartTime() == null) {
				throw new TimeTrackerException(TimeTrackerExceptionCode.START_TIME_MISSING);
			}
			
			long calculatedMinutes = 0;
			
			if (workSessionDTO.getEndTime() != null) {
				
				calculatedMinutes = Duration.between(workSessionDTO.getStartTime(), workSessionDTO.getEndTime()).toMinutes();

			}

			
			if (workSessionDTO.getMinutes() != 0 
					&& calculatedMinutes != workSessionDTO.getMinutes()) {
				
				throw new TimeTrackerException(TimeTrackerExceptionCode.MINUTES_AND_PERIOD_DO_NOT_MATCH);
			}

			if (calculatedMinutes > 0) {
				workSessionDTO.setMinutes(calculatedMinutes);
			}
			
			if (workSessionDTO.getEndTime() != null && workSessionDTO.getMinutes() == 0) {
				
				workSessionDTO.setMinutes(
					Duration.between(workSessionDTO.getStartTime(), workSessionDTO.getEndTime()).toMinutes()
				);
				
			}

			
			ModelMapper modelMapper = new ModelMapper();
			WorkSessionEntity workSessionEntity = modelMapper.map(workSessionDTO, WorkSessionEntity.class);
			
			UserEntity userEntity = userRepository.findByName(workSessionDTO.getUserName());
			
			if (userEntity == null) {
				throw new TimeTrackerException(TimeTrackerExceptionCode.USER_NOT_FOUND);
			}
			
			workSessionEntity.setUserId(userEntity.getId());
			
			TagEntity tagEntity = tagRepository.findByName(workSessionDTO.getTagName());
			
			if (tagEntity == null) {
				throw new TimeTrackerException(TimeTrackerExceptionCode.TAG_NOT_FOUND);
			}			
			
			workSessionEntity.setTagId(tagEntity.getId());
		

			
			if (workSessionDTO.getEndTime() == null) {
				workSessionEntity.setWorkSessionStatusId(Status.STARTED.getId());
			}else {
				workSessionEntity.setWorkSessionStatusId(Status.ENDED.getId());
				
			}
						
			workSessionEntity = workSessionRepository.save(workSessionEntity);
			
			workSessionDTO.setId(workSessionEntity.getId());
			
		} catch (TimeTrackerException e) {	
			//TODO Add log
			System.out.println("** TimeTrackerException: " + e.getMessage());
			throw e;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return workSessionDTO;
		
	}

	
	@Override
	public void cancelWorkSession(String userName, LocalDateTime endTime) throws TimeTrackerException {
		
		try {
			
			WorkSessionEntity workSessionEntity = workSessionRepository.findByUserNameAndStatusName(userName, Status.STARTED.name());

			if (workSessionEntity == null) {
				throw new TimeTrackerException(TimeTrackerExceptionCode.NOT_STARTED_WORK_SESSION);
			}
			
			workSessionEntity.setWorkSessionStatusId(Status.CANCELED.getId());
			workSessionEntity.setEndTime(endTime);
			
			if (workSessionEntity.getEndTime() != null && workSessionEntity.getMinutes() == 0) {
				
				workSessionEntity.setMinutes(
					Duration.between(workSessionEntity.getStartTime(), workSessionEntity.getEndTime()).toMinutes()
				);
				
			}
						
			workSessionEntity = workSessionRepository.save(workSessionEntity);
			
		} catch (TimeTrackerException e) {	
			//TODO Add log
			System.out.println("** TimeTrackerException: " + e.getMessage());
			throw e;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}


	@Override
	public void endWorkSession(String userName, LocalDateTime endTime) throws TimeTrackerException {
		
		try {
			
			WorkSessionEntity workSessionEntity = workSessionRepository.findByUserNameAndStatusName(userName, Status.STARTED.name());

			if (workSessionEntity == null) {
				throw new TimeTrackerException(TimeTrackerExceptionCode.NOT_STARTED_WORK_SESSION);
			}
			
			workSessionEntity.setWorkSessionStatusId(Status.ENDED.getId());
			workSessionEntity.setEndTime(endTime);
			
			if (workSessionEntity.getEndTime() != null && workSessionEntity.getMinutes() == 0) {
				
				workSessionEntity.setMinutes(
					Duration.between(workSessionEntity.getStartTime(), workSessionEntity.getEndTime()).toMinutes()
				);
				
			}
						
			workSessionEntity = workSessionRepository.save(workSessionEntity);
			
		} catch (TimeTrackerException e) {	
			//TODO Add log
			System.out.println("** TimeTrackerException: " + e.getMessage());
			throw e;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	
	}
	
	@Override
	public int getMinutesByUserAndTag(String userName, String tagName) throws TimeTrackerException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Map<String, Integer> getNumberOfSession(String userName, LocalDate from, LocalDate to) {
		
		List <WorkSessionEntity> workSessionEntities = workSessionRepository.findWorkSessionsByUserNameAndStartTime(userName, from);
		
		Map<Long, Integer> tagIdNSessionsMap = new HashMap<>();
		workSessionEntities.forEach(workSessionEntity -> {
			
			Integer nSessions = tagIdNSessionsMap.get(workSessionEntity.getTagId());
			
			if(nSessions == null) {
				tagIdNSessionsMap.put(workSessionEntity.getTagId(), 1);
				return;
			}
			
			tagIdNSessionsMap.put(workSessionEntity.getTagId(), nSessions ++);
		});
		
				
		Map<String, Integer> result = new HashMap<>();
		
		tagIdNSessionsMap.forEach((tagId, nWorkSessions) -> {
			
			Optional<TagEntity> optionalTagEntity = tagRepository.findById(tagId);
			
			if (optionalTagEntity.isPresent()) {
				
				result.put(optionalTagEntity.get().getName(), nWorkSessions);
				
			}
			
		});
		
		return result;
	}
	
}
