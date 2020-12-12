package org.gokapp.trader.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;

import org.gokapp.trader.common.config.RediConfiguration;
import org.gokapp.trader.common.config.TestConfiguration;
import org.gokapp.trader.common.domain.Group;
import org.gokapp.trader.common.domain.User;
import org.gokapp.trader.common.jpa.repositories.GroupRepository;
import org.gokapp.trader.common.jpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(classes = { RediConfiguration.class, TestConfiguration.class })
class TraderCommonApplicationTests {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	@Test
	void contextLoads() {
		System.out.println("All OK! Config OK");
	}

	@Test
	void testGroupRepo() {
		groupRepository.save(new Group("TT1", "GROUP TT1"));
		Group group = groupRepository.findById("TT1").orElse(null);
		assertNotNull(group, "Group cannot be empty");
		assertEquals(group.getGroupdName(), "GROUP TT1", "Group name did not match");
	}

	@Test
	void testRedis() {
		redisTemplate.opsForValue().set("test1", "value1");
		String value = (String) redisTemplate.opsForValue().get("test1");
		assertNotNull(value, "Values cannot be empty");
		assertEquals(value, "value1");
	}

	@Test
	void testUserRepo() {
		userRepository.save(new User("US1", "Test User 1", Collections.emptySet()));
		User user = userRepository.findById("US1").orElse(null);
		assertNotNull(user);
		assertEquals(user.getUserName(), "Test User 1");
		assertEquals(userRepository.count(), 1);
	}

}
