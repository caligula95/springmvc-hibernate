package com.javamaster.service;

import java.util.List;

import com.javamaster.domain.Order;
import com.javamaster.repository.OrderRepository;
import com.javamaster.repository.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void save(Order order) {
		if(order!=null) {
			orderRepository.save(order);
		}
	}

	public void delete(Order order) {
		if(order!=null) {
			orderRepository.delete(order);
		}	
	}

	public List<Order> getAll() {
		return orderRepository.getAll();
	}

	public Order getById(Integer id) {
		if(id!=null) {
			return orderRepository.getById(id);
		}
		return null;
	}

}
