package hieu.productservice.service;

import hieu.productservice.entity.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @CircuitBreaker(name = "getProductById", fallbackMethod = "getProductByIdFallback")
    public Product getProductById(Long id) {
        if (id == 4) {
            throw new RuntimeException("Simulated error"); // For demonstration purposes, simulating a service failure.
        }
        return new Product(id, "Sample Product", 99.99);
    }

    public Product getProductByIdFallback(Long id, Throwable throwable) {
        log.error("Fallback method");
        return new Product(id, "Fallback Product", 0);
    }
}
