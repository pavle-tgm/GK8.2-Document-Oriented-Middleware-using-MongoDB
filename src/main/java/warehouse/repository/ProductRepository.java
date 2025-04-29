package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import warehouse.model.ProductData;

@Repository
public interface ProductRepository extends MongoRepository<ProductData, String> {

    public ProductData findByProductID(String productID);
    public List<ProductData> findByWarehouseID(String warehouseID);

 }
