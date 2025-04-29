package warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "warehouseData")
public class Warehouse {

    @Id
    private String warehouseID;
    private String warehouseName;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;

    public Warehouse(String warehouseID, String warehouseName, String warehousePostalCode, String warehouseCity, String warehouseCountry) {
        this.warehouseID = warehouseID;
        this.warehouseName = warehouseName;
        this.warehousePostalCode = warehousePostalCode;
        this.warehouseCity = warehouseCity;
        this.warehouseCountry = warehouseCountry;
    }
    
    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }


    public String getWarehouseID() {
        return warehouseID;
    }
}
