Hier ist eine gekürzte Version der `README.md` für dein Projekt:

---

# Lagerverwaltung mit Spring Boot & MongoDB

Ein einfaches Spring-Boot-Projekt zur Verwaltung von Produkten in Lagerhäusern. Die Daten werden in MongoDB gespeichert und über eine REST-API bereitgestellt.

---

## Endpunkte

| Methode | Pfad       | Beschreibung          |
|---------|------------|-----------------------|
| GET     | `/product` | Alle Produkte         |
| POST    | `/product` | Produkt hinzufügen    |

**Beispiel (POST):**
```json
{
  "warehouseID": "1",
  "productID": "00-999999",
  "productName": "Testprodukt",
  "productCategory": "Testkategorie",
  "productQuantity": 100
}
```

---

## Starten

1. MongoDB starten
2. Anwendung ausführen mit:
   ```bash
   ./mvnw spring-boot:run
   ```
3. API: [http://localhost:8080/product](http://localhost:8080/product)

---

## Beispiel-Daten

In `Application.java` werden beim Start Beispielprodukte gespeichert und über `findAll()`, `findByProductID()` und `findByWarehouseID()` ausgegeben.

**Aufrufen der Produkte**
```
test> show dbs
admin         40.00 KiB
config        72.00 KiB
local         40.00 KiB
warehouseDB  144.00 KiB
test> use warehouseDB
switched to db warehouseDB
warehouseDB> show collections
productData
warehouseData
warehouseDB> db.productData.find().pretty()
```
### CRUD über MongoShell

**Create** – Einfügen eines Dokuments
```javascript
db.productData.insertOne({
  warehouseID: "3",
  productID: "99-000001",
  productName: "Testprodukt",
  productCategory: "Testkategorie",
  productQuantity: 100
})
```

---

**Read** – Alle Produkte abrufen
```javascript
db.productData.find()
```

Read mit Filter – z.B. alle Produkte aus Warehouse "1"
```javascript
db.productData.find({ warehouseID: "1" })
```

---

**Update** – Produktmenge ändern
```javascript
db.productData.updateOne(
  { productID: "00-443175" },
  { $set: { productQuantity: 999 } }
)
```

---

**Delete** – Ein Produkt löschen
```javascript
db.productData.deleteOne({ productID: "00-443175" })
```

---

**Delete All** – (z. B. für Testzwecke)
```javascript
db.productData.deleteMany({})
```

---

Wenn du magst, kann ich dir auch zeigen, wie du diese Befehle als `mongoimport` oder über Compass ausführst. Möchtest du das?
