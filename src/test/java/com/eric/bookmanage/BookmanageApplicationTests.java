package com.eric.bookmanage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eric.bookmanage.domain.entity.Users;
import com.eric.bookmanage.domain.mapper.UsersMapper;

@SpringBootTest
class BookmanageApplicationTests {

	@Autowired
	private UsersMapper usersMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<Users> userList = usersMapper.selectList(null);
		assertEquals(1, userList.size(), "userList size is not 1");
		userList.forEach(System.out::println);
	}

}
