package com.javamaster.repository;

import java.util.ArrayList;
import java.util.List;

import com.javamaster.domain.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private SessionFactory sessionFactory;
	public void save(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	public void delete(Order order) {
		sessionFactory.getCurrentSession().delete(order);
	}

	public List<Order> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}

	public Order getById(Integer id) {
		Order order = sessionFactory.getCurrentSession().get(Order.class, id);
		return order;
	}
}
