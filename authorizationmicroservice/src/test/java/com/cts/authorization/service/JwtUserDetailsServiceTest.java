package com.cts.authorization.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.authorization.exception.UserNotFoundException;
import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserDao;

@SpringBootTest
class JwtUserDetailsServiceTest {
	
	@Mock
	private UserDao userDao;

	@Mock
	private PasswordEncoder bcryptEncoder;

	@InjectMocks
	private JwtUserDetailsService service;
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetUserIdByUserNameSuccess() throws UserNotFoundException {
		User user=new User(1,"Ramesh","ramesh");
		when(userDao.findByUserName("Ramesh")).thenReturn(user);
		assertThat(service.getUserIdByUserName("Ramesh")).isEqualTo(1);
	}
	
	@Test
	void loadUserByUserNameShouldThrowExceptionTest() {
		when(userDao.findByUserName("wrongUserName")).thenReturn(null);
		assertThatThrownBy(() -> service.loadUserByUsername("wrongUserName")) 
        .isInstanceOf(UsernameNotFoundException.class)
        .hasMessage("User not found with username: wrongUserName");
		verify(userDao, Mockito.times(1)).findByUserName("wrongUserName");
	}
	
	@Test
	void loadUserByUserNameShouldUserNameTest() {
		when(userDao.findByUserName("admin")).thenReturn(new User(1,"admin","pass"));
		assertThat(service.loadUserByUsername("admin")).isNotNull();
		verify(userDao, Mockito.times(1)).findByUserName("admin");
	}
	
	@Test
	void testRegisterUser() {
		User user = new User(1,"Ramesh","ramesh@1234");
		when(userDao.save(user)).thenReturn(user);
		assertNotNull(service.registerUser(user));
	}

}
