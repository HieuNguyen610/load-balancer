package hieu.productservice.controller;


import hieu.productservice.entity.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProductById")
    public Product getProductById(@PathVariable Long id) {
        log.info("Get product by id from server 2 ");
        if (id == 4) {
            throw new RuntimeException("Simulated error"); // For demonstration purposes, simulating a service failure.
        }
        // For simplicity, returning a hardcoded product. In a real application, you'd query the database.
        return new Product(id, "Sample Product", 99.99);
    }

    public Product fallbackGetProductById(Long id, Throwable throwable) {
        log.error("Fallback method");
        return new Product(id, "Fallback Product", 0);
    }
}
