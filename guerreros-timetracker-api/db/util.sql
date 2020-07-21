

SELECT * FROM gstt_timeperiod a 
	left outer join gstt_user b on a.userId = b.id
    left outer join gstt_timeperiod_status c on a.timeperiodStatusId = c.id

where b.name = '' and c.name = ''



INSERT INTO gstt_timeperiod (tagId, userId, ´from´, ´to´, secs, timePeriodStatusId) 
    values (1,1,'27-04-20 22:00:00','27-04-20 22:00:00',NULL,1)



SELECT a.* from gstt_tag a 
inner join gstt_user_tag b on (a.id = b.tagId)
inner join gstt_user c on (b.userId = c.id)
where c.name = 'SYSTEM'

