create table ERS_USERS (
	ERS_USERS_ID serial primary key not null,
	ERS_USERNAME VARCHAR(200) unique not null,
	ERS_PASSWORD VARCHAR(200) not null,
	USER_FIRST_NAME VARCHAR(200) not null,
	USER_LAST_NAME VARCHAR(200) not null,
	USER_EMAIL VARCHAR(200) not null,
	USER_ROLE_ID integer not null references ERS_USER_ROLES (ERS_USER_ROLE_ID)
);

create table ERS_USER_ROLES (
	ERS_USER_ROLE_ID serial primary key not null,
	USER_ROLE integer not null
);

create table ERS_REIMBURSEMENT (
	REIMB_ID serial primary key not null,
	REIMB_AMOUNT integer not null,
	REIMB_SUBMITTED timestamp with time zone default current_timestamp not null,
	REIMB_RESOLVED timestamp with time zone default current_timestamp,
	REIMB_DESCRIPTION VARCHAR(250),
	REIMB_RECEIPT bytea,
	REIMB_AUTHOR integer not null references ERS_USERS (ERS_USERS_ID),
	REIMB_RESOLVER integer references ERS_USERS (ERS_USERS_ID),
	REIMB_STATUS_ID integer not null references ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID),
	REIMB_TYPE_ID integer not null references ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID)
);

create table ERS_REIMBURSEMENT_STATUS (
	REIMB_STATUS_ID serial primary key not null,
	REIMB_STATUS VARCHAR(10) not null
);

create table ERS_REIMBURSEMENT_TYPE (
	REIMB_TYPE_ID serial primary key not null,
	REIMB_TYPE VARCHAR(20) not null
);

--modifiers
drop table ERS_USERS;
drop table ERS_USER_ROLES;
drop table ERS_REIMBURSEMENT;
drop table ERS_REIMBURSEMENT_STATUS;
drop table ERS_REIMBURSEMENT_TYPE;

--inserts
insert into ers_reimbursement_status (reimb_status) values ('pending');
insert into ers_reimbursement_status (reimb_status) values ('denied');
insert into ers_reimbursement_status (reimb_status) values ('approved');

insert into ers_reimbursement_type (reimb_type) values ('lodging');
insert into ers_reimbursement_type (reimb_type) values ('travel');
insert into ers_reimbursement_type (reimb_type) values ('food');
insert into ers_reimbursement_type (reimb_type) values ('other');

insert into 
	"ers_reimbursement" (reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) 
	values ('500', 'test ticket', '', '1', '1', '1');

insert into 
	"ers_reimbursement" (reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) 
	values ('500', 'test ticket', '', '1', '2', '3');

insert into 
	"ers_reimbursement" (reimb_amount, reimb_description, reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) 
	values ('500', 'test ticket', '', '1', '1', '1');
