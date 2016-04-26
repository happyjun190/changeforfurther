package com.mavenweb.service.redisexercise;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class TestRedisPubAndSub extends JedisPubSub {
	
	
	@Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage: channel["+channel+"], message["+message+"]");
    }


    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage: channel["+channel+"], message["+message+"]");
    }
 

    @Override
    public void onSubscribe(String channel,int subscribedChannels) {
        System.out.println("onSubscribe: channel["+channel+"],"+ "subscribedChannels["+subscribedChannels+"]");
    }

 
    @Override
    public void onUnsubscribe(String channel,int subscribedChannels) {
        System.out.println("onUnsubscribe: channel["+channel+"], "+ "subscribedChannels["+subscribedChannels+"]");
    }


    @Override
    public void onPUnsubscribe(String pattern,int subscribedChannels) {
        System.out.println("onPUnsubscribe: pattern["+pattern+"],"+ "subscribedChannels["+subscribedChannels+"]");
    }


    @Override
    public void onPSubscribe(String pattern,int subscribedChannels) {
        System.out.println("onPSubscribe: pattern["+pattern+"], "+ "subscribedChannels["+subscribedChannels+"]");
    }
    
    
	public static void main(String args[]) {
    	Jedis jedis = null;
    	try {
    		jedis = new Jedis("localhost");
    		jedis.auth("zaq1@WSX");
    		TestRedisPubAndSub testRedisPubAndSub = new TestRedisPubAndSub();
    		testRedisPubAndSub.proceed(jedis.getClient(),"news.share1", "news.blog1");
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		if(jedis!=null) {
    			jedis.disconnect();
    		}
    	}
    	
    }
    
}
