package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    @PostMapping
    public ProductData addProduct(@RequestBody ProductData product) {
        return productRepository.save(product);
    }

    // READ (alle Produkte)
    @GetMapping
    public List<ProductData> getAllProducts() {
        return productRepository.findAll();
    }

    // READ (nach ProduktID)
    @GetMapping("/id/{productID}")
    public ProductData getByProductID(@PathVariable String productID) {
        return productRepository.findByProductID(productID);
    }

    // UPDATE
    @PutMapping("/{productID}")
    public ProductData updateProduct(@PathVariable String productID, @RequestBody ProductData updatedProduct) {
        ProductData existingProduct = productRepository.findByProductID(productID);
        if (existingProduct != null) {
            existingProduct.setWarehouseID(updatedProduct.getWarehouseID());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductCategory(updatedProduct.getProductCategory());
            existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
            return productRepository.save(existingProduct);
        } else {
            return null; // oder throw new ResponseStatusException(...)
        }
    }

    // DELETE
    @DeleteMapping("/{productID}")
    public void deleteProduct(@PathVariable String productID) {
        ProductData existingProduct = productRepository.findByProductID(productID);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
        }
    }
}
