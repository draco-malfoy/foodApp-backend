package com.mt.FoodApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.FoodApp.exception.OrderNotFoundException;
import com.mt.FoodApp.model.Order;
import com.mt.FoodApp.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/getOrders")
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = orderService.findAllOrders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

	@GetMapping("/getOrderById/{id}")
	public ResponseEntity<Order> getOrders(@PathVariable("id") long id) {
		Optional<Order> order = orderService.findById(id);
		if (order.get() == null) {
			throw new OrderNotFoundException("Order was not found.");
		}
		return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
	}

	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order inputOrder) {
		Order order = orderService.addOrder(inputOrder);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order inputOrder) {
		Order order = orderService.updateOrder(inputOrder);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") long id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
