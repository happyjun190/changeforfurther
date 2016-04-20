package com.mavenweb.service.rabbitmq;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class EmitLog {
	
	private static final String EXCHANGE_NAME = "logs";
	
	public static void main(String args[]) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String line = scanner.nextLine();
		
		while(!"exit".equals(line)) {
			//String message = "hello world";
			channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.PERSISTENT_TEXT_PLAIN, line.getBytes());
			System.out.println(" [x] Sent '" + line + "'");
			line = scanner.nextLine();
		}
		
		channel.close();
		connection.close();
		
	}
	
}
