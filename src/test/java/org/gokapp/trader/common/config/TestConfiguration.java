package org.gokapp.trader.common.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import redis.embedded.RedisServer;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {

	private RedisServer redisServer;

	@Autowired
	private RediConfiguration redisConfigurtion;

	@PostConstruct
	public void init() {
		System.out.println("Initiatliziing Embedded Redis server on: " + redisConfigurtion.getHostName() + " : "
				+ redisConfigurtion.getPort());
		redisServer = new RedisServer(redisConfigurtion.getPort());
		redisServer.start();

	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Sroping the Embedded redis server");
		redisServer.stop();
	}
}
