CREATE table todo(
	id int primary key auto_increment,
	name varchar(50),
	detail text,
	priority varchar(10),
	timelimit date
);

insert into todo(id,name,detail,priority,timelimit)
values ('1','テスト1','一番優先度が高い。','★★★','2015-06-20');

insert into todo(id,name,detail,priority,timelimit)
values ('2','テスト2','二番目に優先度が高い','★★','2015-06-22');

insert into todo(id,name,detail,priority,timelimit)
values ('3','テスト3','三番目に優先度が高い','★','2015-06-25');


