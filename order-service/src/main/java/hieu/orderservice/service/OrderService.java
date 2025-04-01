package hieu.orderservice.service;

import hieu.orderservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;

    public Product getProductById(Long id) {
        return productClient.getProductById(id);
    }
}
