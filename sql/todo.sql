CREATE table todo(
	id int primary key auto_increment,
	name varchar(50),
	priority varchar(10),
	timelimit date
);

insert into todo(id,name,priority,timelimit)
values ('1','テスト1','★★★','2015-06-20');

insert into todo(id,name,priority,timelimit)
values ('2','テスト2','★★','2015-06-22');

insert into todo(id,name,priority,timelimit)
values ('3','テスト3','★','2015-06-25');


