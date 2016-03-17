package com.mavenweb.service.redisexercise;

import redis.clients.jedis.Jedis;

public class TestRedisConnector {
	private static Jedis jedis;

	public static void main(String args[]) {
		jedis = new Jedis("localhost");
		jedis.auth("zaq1@WSX");
		System.out.println("Connection to redis server successfully");
		//查看服务器是否运行
		System.out.println("Server is running: "+ jedis.ping());
		
		//redis set value
		jedis.set("w3ckey", "Redis tutorial");
		
		
		//redis get value
		System.out.println("Stored string in redis:"+jedis.get("w3ckey"));
		
	}
}
