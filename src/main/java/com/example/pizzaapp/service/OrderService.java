package com.example.pizzaapp.service;

import com.example.pizzaapp.model.Order;
import com.example.pizzaapp.model.User;
import com.example.pizzaapp.model.dto.OrderDto;
import com.example.pizzaapp.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    public OrderService(OrderRepository orderRepository,
                        ModelMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    public Order createOrder(OrderDto orderDto) {
        return orderRepository.save(
                mapper.map(orderDto, Order.class));
    }

    public List<Order> getByUserOrderByPlacedAtDesc(User user, Pageable pageable) {
        return orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
    }
}
