package com.store.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.store.entities.Client;
import com.store.entities.Order;
import com.store.entities.OrderItem;
import com.store.entities.Product;
import com.store.repositories.ClientRepository;
import com.store.repositories.OrderItemRepository;
import com.store.repositories.OrderRepository;
import com.store.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "The Lord of the Rings", 90.5);
		Product p2 = new Product(null, "Smart TV", 2190.0);
		Product p3 = new Product(null, "Macbook Pro", 1250.0);
		Product p4 = new Product(null, "PC Gamer", 1200.0);
		Product p5 = new Product(null, "Rails for Dummies", 100.99); 
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		Client u1 = new Client(null, "Pedro Souza");
		//Client u2 = new Client(null, "Alex Green");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		//Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		//Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		userRepository.saveAll(Arrays.asList(u1));
		orderRepository.saveAll(Arrays.asList(o1));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		//OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		//OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2));
		orderRepository.saveAll(Arrays.asList(o1));
	}
}
