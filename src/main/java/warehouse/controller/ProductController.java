package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ProductData addProduct(@RequestBody ProductData product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<ProductData> getAllProducts() {
        return productRepository.findAll();
    }
}
