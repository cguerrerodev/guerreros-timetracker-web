

insert into gstt_user (name) values ('SYSTEM');


insert into gstt_worksession_status (id, name) VALUES (1, 'STARTED');
insert into gstt_worksession_status (id, name) VALUES (2, 'ENDED');
insert into gstt_worksession_status (id, name) VALUES (3, 'CANCELED');

insert into gstt_tag (created_by, name ) VALUES (1, 'Work');
insert into gstt_tag (created_by, name ) VALUES (1, 'Study');

insert into gstt_user_tag (user_id, tag_id) values (1,1);
insert into gstt_user_tag (user_id, tag_id) values (1,2)

