package com.mavenweb.service.rabbitmq;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;


// round-robin  多个consumer 轮转 消费 队列
public class Worker {
	
	
	
	
	
	private final static String QUEUE_NAME = "task_queue";
	
	public static void main(String args[]) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		final Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();
		
		//This queueDeclare change needs to be applied to both the producer and consumer code.
		boolean durable = true;
		
		//we want to make sure the queue exists before we try to consume messages from it.
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	

		channel.basicQos(1);
		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, 
									   AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x]	 Received '" + message + "'");
				try {
					dowork(message);
				} finally {
					System.out.println(" [x] done");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
				
			}
			
		};
		
		channel.basicConsume(QUEUE_NAME, true, consumer);
		
	
	}
	
	
	private static void dowork(String task) {
		
		for(char ch : task.toCharArray()) {
			
			if(ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
