package com.mt.FoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.FoodApp.model.Order;
import com.mt.FoodApp.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder(Order order) {
		Optional<Order> existingOrder = orderRepository.findById(order.getId());
		if (order.getStatus() != null)
			existingOrder.get().setStatus(order.getStatus());
		if (order.getPrice() != 0)
			existingOrder.get().setPrice(order.getPrice());
		if (order.getFoodType() != null)
			existingOrder.get().setFoodType(order.getFoodType());
		if (order.getTotalItems() != 0)
			existingOrder.get().setTotalItems(order.getTotalItems());
		if (order.getOrderItems() != null)
			existingOrder.get().setOrderItems(order.getOrderItems());
		return orderRepository.save(existingOrder.get());
	}

	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
