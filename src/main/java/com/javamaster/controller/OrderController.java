package com.javamaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javamaster.domain.Order;
import com.javamaster.service.OrderService;
import com.javamaster.service.OrderServiceImpl;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getOrderPage(Model model) {
		List<Order> orders = orderService.getAll();
		model.addAttribute("orderList", orders);
		return "order";
	}
	
	@RequestMapping(value = "/add-new-order", method=RequestMethod.GET)
	public String addNewOrderPage() {
		return "addNewOrder";
	}
	
	@RequestMapping(value="/add-new-order", method=RequestMethod.POST)
	public String addNewOrder(@RequestParam(value="title") String title, @RequestParam(value="price") Double price) {
		Order order = new Order();
		order.setTitle(title);
		order.setPrice(price);
		orderService.save(order);
		return "redirect:/";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String deleteItem(@PathVariable Integer id) {
		Order order = orderService.getById(id);
		orderService.delete(order);
		return "redirect:/";
	}
}
