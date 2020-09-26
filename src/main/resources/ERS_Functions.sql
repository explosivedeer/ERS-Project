-- Login Method
create or replace function login(in username varchar, in passwd varchar) returns integer as $passed_id$
declare verify boolean;
declare passed_id integer;
	begin 
		passed_id := -1;
		select ERS_USERS.ERS_PASSWORD = $2
		from ERS_USERS
		where ERS_USERS.ERS_USERNAME = $1
		into verify;
			if verify = true then
				select ERS_USERS_ID from ERS_USERS where ERS_USERS.ERS_USERNAME = $1 and ERS_USERS.ERS_PASSWORD = $2 
				into passed_id;
				return passed_id;
			end if;
	return passed_id;
	end;
$passed_id$ language plpgsql;
-- This will verify the login, if verified, it will return the id associated to the account. Otherwise it will return -1, indicating the login was invalid.
insert into ers_user_roles (user_role) values (1);
insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('testuser1', 'testpassword1', 'testFirstName', 'testLastName', 'testEmail@email.com', 1);
select * from ers_users;

select * from ers_users where ers_username = 'testuser1';

select * from login('testuser1', 'testpassword1');