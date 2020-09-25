package com.legit.repo;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.legit.model.User;

public class UserDaoTest {
	
	private UserDao ud;
	
	@BeforeEach
	public void setup() {
		ud = new UserDao();
	}
	
	//We need to test the insert statement, but the username must be unique due to constraint created in the postgresql database.
	@Test
	public void InsertTest() {
		User user = new User(0, LocalDateTime.now().toString(), "password");
		int in = ud.create(user);
		assertTrue(in>0);
	}
	
	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		assertNotNull(users);
		assertNotEquals(0, users.size());
		System.out.println(users);
	}
}
