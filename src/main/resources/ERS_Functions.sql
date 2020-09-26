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
				select ERS_USERS_ID from ERS_USERS where ERS_USERS.ERS_USERS = $1 and ERS_USERS.ERS_PASSWORD = $2 
				into passed_id;
				return passed_id;
			end if;
	return passed_id;
	end;
$passed_id$ language plpgsql;
-- This will verify the login, if verified, it will return the id associated to the account. Otherwise it will return -1, indicating the login was invalid.