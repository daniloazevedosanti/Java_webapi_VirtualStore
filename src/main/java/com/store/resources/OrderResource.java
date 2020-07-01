package com.store.resources;

import java.net.URI;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.store.entities.Order;
import com.store.entities.OrderItem;
import com.store.entities.RequestOrder;
import com.store.repositories.OrderItemRepository;
import com.store.services.ClientService;
import com.store.services.OrderService;
import com.store.services.ProductService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private ClientService clientServices;
	
	@Autowired
	private ProductService productServices;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();  
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody RequestOrder res) {
		
		Instant moment =  Instant.now();
		var u1 = clientServices.findById(res.getClientId());
		var p1 = productServices.findById(res.getProductId());
		
		Order obj = new Order(null, moment, u1);
		service.insert(obj);
		
		OrderItem oi1 = new OrderItem(obj, p1, res.getQuantity(), p1.getPrice());
		orderItemRepository.save(oi1);
		
		var order = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
	}
}
