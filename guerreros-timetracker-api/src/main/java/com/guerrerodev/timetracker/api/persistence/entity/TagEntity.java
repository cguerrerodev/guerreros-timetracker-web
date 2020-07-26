package com.guerrerodev.timetracker.api.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "gstt_tag")

@NamedNativeQuery(
		name = "TagEntity.findByUserName",
		query = "select t.* from gstt_tag t left outer join gstt_user_tag ut on t.id = ut.tag_id "
				+ "left outer join gstt_user u on ut.user_id = u.id"
				+ " where u.name = ?",
		resultClass=TagEntity.class)

                    
public class TagEntity {

	@Id
	private long id;
	
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private UserEntity createdBy;
	
	@ManyToMany
	@JoinTable(
            name = "gstt_user_tag",
            joinColumns = {@JoinColumn(name = "tag_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
	private List<UserEntity> users;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}



	
}
