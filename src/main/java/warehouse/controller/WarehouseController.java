package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.model.Warehouse;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseRepository repository;

    @PostMapping
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
        return repository.save(warehouse);
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable String id) {
        repository.deleteById(id);
    }
}
