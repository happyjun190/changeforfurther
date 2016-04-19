package com.mavenweb.service.rabbitmq;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Send {
	
	private final static String QUEUE_NAME = "task_queue";
	
	
	public static void main(String args[]) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		
		//This queueDeclare change needs to be applied to both the producer and consumer code.
		boolean durable = true;
		//序列声明  Declaring a queue is idempotent - it will only be created if it doesn't exist already
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String line = scanner.nextLine();
		
		while(!"exit".equals(line)) {
			//String message = "hello world";
			channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, line.getBytes());
			System.out.println(" [x] Sent '" + line + "'");
			line = scanner.nextLine();
		}
		
		channel.close();
		connection.close();
		
	}
	
	
}
