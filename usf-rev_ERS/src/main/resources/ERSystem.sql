create table app_user (
	id serial primary key,
	username text not null unique,
	passwd text not null
);

insert into app_user (username, passwd) values ('app', 'pass');
select * from app_user;

drop table app_user;