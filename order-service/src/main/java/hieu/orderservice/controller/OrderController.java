package hieu.orderservice.controller;

import hieu.orderservice.entity.Product;
import hieu.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/{id}/product")
    public Product getProductById(@PathVariable Long id) {
        log.info("Getting product with id: {}", id);
        return orderService.getProductById(id);
    }
}
