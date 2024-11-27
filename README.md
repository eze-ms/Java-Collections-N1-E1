# Sales App

## 📄 Description
This project demonstrates the implementation of a simple sales system in Java. It includes key concepts like exception handling, object-oriented programming (OOP), and the use of collections. The app handles products and calculates the total price of a sale, ensuring no sales are processed without products.

### Functionality
1. **Classes:**
   - `Product`: Represents individual products with attributes such as `id`, `name`, and `price`.
   - `Sale`: Manages a list of products, calculates the total price, and throws a custom exception if the sale is empty.
   - `VendaBuidaException`: A custom exception that prevents processing an empty sale.
2. **Methods:**
   - `addProduct(Product product)`: Adds a product to the sale.
   - `calculateTotal()`: Calculates the total price of the sale. Throws `VendaBuidaException` if the sale has no products.
   - `showProducts()`: Displays all products in the sale.

---

## 💻 Technologies Used
- **Java 17**
- **IntelliJ IDEA** as the development environment

---

## 📋 Requirements
- **Java Development Kit (JDK):** Version 17 or higher.
- **IDE:** IntelliJ IDEA or any Java-compatible IDE.

---

## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/eze-ms/Java-Collections-N1-E1
