package com.guerrerodev.timetracker.api.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity(name = "gstt_worksession")

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "WorkSessionEntity.findByUserNameAndStatusName",
			query = "select w.* from gstt_worksession w left outer join gstt_user u on w.user_id = u.id "
					+ "left outer join gstt_worksession_status s on w.work_session_status_id = s.id"
					+ " where u.name = ? and s.name = ?",
			resultClass=WorkSessionEntity.class),
	
	@NamedNativeQuery(
			name = "WorkSessionEntity.findWorkSessionsByUserNameAndStartTimeBetween",
			query = "SELECT b.* FROM gstt_user a " + 
					"LEFT OUTER JOIN gstt_worksession b on a.id = b.user_id " + 
					"LEFT OUTER JOIN gstt_tag c on b.tag_id = c.id " + 
					"WHERE " + 
					"a.name = ? and " + 
					"b.start_time BETWEEN ? and ? ",
			resultClass=WorkSessionEntity.class)
})

public class WorkSessionEntity {

	@Id
	private long id;
	
	private long tagId;
	
	private long userId;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private int workSessionStatusId; 
	
	private long minutes;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getWorkSessionStatusId() {
		return workSessionStatusId;
	}

	public void setWorkSessionStatusId(int workSessionStatusId) {
		this.workSessionStatusId = workSessionStatusId;
	}

	public long getMinutes() {
		return minutes;
	}

	public void setMinutes(long l) {
		this.minutes = l;
	}
	



}
