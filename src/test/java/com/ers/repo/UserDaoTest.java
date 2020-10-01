package com.ers.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ers.model.User;

public class UserDaoTest {
	
	private UserDao ud;
	
	@BeforeEach
	public void setup() {
		ud = new UserDao();
	}
	
	
	@Test
	public void verifyUserTest() {
		assertEquals(true, ud.verifyUser("testuser1", "testpassword1"));
	}
}
