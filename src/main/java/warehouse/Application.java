package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import warehouse.model.ProductData;
import warehouse.model.Warehouse;
import warehouse.repository.ProductRepository;
import warehouse.repository.WarehouseRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "warehouse.repository")
public class Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private WarehouseRepository warehouseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		productRepository.deleteAll();
		warehouseRepository.deleteAll();

		warehouseRepository.save(new Warehouse("1", "Zentrallager Berlin", "10115", "Berlin", "Deutschland"));

		productRepository.save(new ProductData("1", "P-001", "Bio Orangensaft", "Getränk", 1000));
		productRepository.save(new ProductData("1", "P-002", "Bio Apfelsaft", "Getränk", 900));
		productRepository.save(new ProductData("1", "P-003", "Mineralwasser", "Getränk", 1500));

		productRepository.save(new ProductData("1", "P-004", "Waschmittel Color", "Waschmittel", 700));
		productRepository.save(new ProductData("1", "P-005", "Waschmittel Weiß", "Waschmittel", 800));
		productRepository.save(new ProductData("1", "P-006", "Weichspüler", "Waschmittel", 600));

		productRepository.save(new ProductData("1", "P-007", "Katzenfutter Rind", "Tierfutter", 500));
		productRepository.save(new ProductData("1", "P-008", "Hundefutter Huhn", "Tierfutter", 650));
		productRepository.save(new ProductData("1", "P-009", "Katzenfutter Lachs", "Tierfutter", 550));
		productRepository.save(new ProductData("1", "P-010", "Knochen Snack", "Tierfutter", 400));
	}
}
