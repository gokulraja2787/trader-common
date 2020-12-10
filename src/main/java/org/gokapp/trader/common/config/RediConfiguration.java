package org.gokapp.trader.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import lombok.Getter;

/**
 * Configures redis
 * 
 * @author gokulr
 *
 */
@Configuration
@EnableRedisRepositories(basePackages = {"org.gokapp.trader.common.jpa.repositories"})
public class RediConfiguration {

	@Value("${spring.redis.host:localhost}")
	@Getter
	private String hostName;
	@Value("${spring.redis.port:9000}")
	@Getter
	private int port;

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory(new RedisStandaloneConfiguration(hostName, port));
		return factory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}
