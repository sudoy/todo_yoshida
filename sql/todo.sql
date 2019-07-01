CREATE table todo(
	id int primary key auto_increment,
	name varchar(100),
	detail text,
	priority int,
	timelimit date
);

insert into todo(id,name,detail,priority,timelimit)
values ('1','テスト1','一番優先度が高い。','3','2015-06-20');

insert into todo(id,name,detail,priority,timelimit)
values ('2','テスト2','二番目に優先度が高い','2','2015-06-22');

insert into todo(id,name,detail,priority,timelimit)
values ('3','テスト3','三番目に優先度が高い','1','2015-06-25');

insert into todo(id,name,detail,priority)
values ('4','テスト4','四番目に優先度が高い','1');
