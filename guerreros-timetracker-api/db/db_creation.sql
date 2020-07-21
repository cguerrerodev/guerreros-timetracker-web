
create database gstimetracker;

create user 'gstimetrackeruser'@'%' identified by 'gstimetrackeruser';

grant all on gstimetracker.* to 'gstimetrackeruser'@'%';

use gstimetracker;


CREATE TABLE gstt_worksession_status (
  id int(11) NOT NULL,
  name varchar(30) NOT NULL UNIQUE,
  description varchar(200),
  
  PRIMARY KEY (id)
);


CREATE TABLE gstt_user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL UNIQUE,
  e_mail varchar(50),
  
  PRIMARY KEY (id)
);

CREATE TABLE gstt_tag (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL UNIQUE,
  created_by int(11) NOT NULL,
  description varchar(200),
  
  PRIMARY KEY (id),
  FOREIGN KEY (created_by)  	REFERENCES gstt_user(id)
);


CREATE TABLE gstt_worksession (
    id 		                int(11) NOT NULL AUTO_INCREMENT,
    tag_id 	              	int(11) NOT NULL,
    user_id                	int(11) NOT NULL,
    start_time 	      		datetime NOT NULL,
    end_time 	            datetime DEFAULT NULL,
    work_session_status_id  int(11) NOT NULL,
    minutes				    int(11),

    PRIMARY KEY (id),
    FOREIGN KEY (user_id)  	              REFERENCES gstt_user(id),
    FOREIGN KEY (tag_id)  	              REFERENCES gstt_tag(id),
    FOREIGN KEY (work_session_status_id)  REFERENCES gstt_worksession_status(id)
);

CREATE TABLE gstt_tag_worksession (
  id               int(11) NOT NULL AUTO_INCREMENT,
  tag_id           int(11) NOT NULL,
  work_session_id  int(11) NOT NULL,
  
  PRIMARY KEY (id),
  FOREIGN KEY (tag_id)  	    REFERENCES gstt_tag(id),
  FOREIGN KEY (work_session_id) REFERENCES gstt_worksession(id)
);

create table gstt_user_tag(
    
  id               int(11) NOT NULL AUTO_INCREMENT,	
  user_id          int(11) NOT NULL,
  tag_id           int(11) NOT NULL,
    
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES gstt_user(id),
  FOREIGN KEY (tag_id) 	REFERENCES gstt_tag(id)
)
