package com.javamaster.repository;

import java.util.List;

import com.javamaster.domain.Order;

public interface OrderRepository {

	void save(Order order);
	
	void delete(Order order);
	
	List<Order> getAll();
	
	Order getById(Integer id);
}
