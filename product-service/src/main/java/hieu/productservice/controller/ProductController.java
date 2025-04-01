package hieu.productservice.controller;


import hieu.productservice.entity.Product;
import hieu.productservice.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        log.info("Get product by id from server 1 ");
        // For simplicity, returning a hardcoded product. In a real application, you'd query the database.
        return productService.getProductById(id);
    }
}
