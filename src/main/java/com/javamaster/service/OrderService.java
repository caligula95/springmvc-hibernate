package com.javamaster.service;

import java.util.List;

import com.javamaster.domain.Order;

public interface OrderService {
	
	void save(Order order);

	void delete(Order order);

	List<Order> getAll();

	Order getById(Integer id);
}
