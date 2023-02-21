package com.example.pizzaapp.web;

import com.example.pizzaapp.model.Order;
import com.example.pizzaapp.model.User;
import com.example.pizzaapp.model.dto.OrderDto;
import com.example.pizzaapp.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderProps orderProps;

    public OrderController(OrderService orderService, OrderProps orderProps) {
        this.orderService = orderService;
        this.orderProps = orderProps;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new OrderDto());
        return "order";
    }

    @PostMapping
    public String processOrder(@Valid OrderDto orderDto,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "order";
        }

        orderDto.setUser(user);
        orderService.createOrder(orderDto);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(
            @AuthenticationPrincipal User user,
            Model model) {

        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
        model.addAttribute("orders",
                orderService.getByUserOrderByPlacedAtDesc(user, pageable));

        return "orderList";
    }
}
