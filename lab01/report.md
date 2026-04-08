#### Objective

The purpose of this lab is to implement a simple layered architecture using Java. The system simulates a basic order processing workflow by separating responsibilities into Persistence, Business, and Presentation layers. Additionally, Constructor Injection is used to manage dependencies between layers.



#### System Architecture

The application is designed using three main layers:



##### 1\. Persistence Layer (Class: ProductRepository)



This layer is responsible for data access and storage operations.

Stores product data using HashMap<Long, Product>



###### Provides methods:

* findById(Long id)
* save(Product product)
* Contains initial test data for products



This layer simulates a database and isolates data access from business logic.



##### 2\. Domain Layer (Class: Product)



This layer represents the core business entity.



###### Fields:

* Long id
* String name
* int stock



###### Methods:

* Getters for all fields
* setStock(int stock) to update product stock



This class is used across all layers.



##### 3\. Business Layer (Class: OrderService)



This layer contains business logic for placing orders.



###### Responsibilities:

* Retrieve product from repository
* Validate stock availability
* Reduce stock if order is valid
* Save updated product



ProductRepository is injected via constructor





###### placeOrder(Long productId, int quantity)

* Throws IllegalArgumentException if stock is insufficient
* Updates stock otherwise



##### 4\. Presentation Layer (Class: OrderController)



This layer handles user interaction.



###### Responsibilities:

* Receive user request
* Call business layer
* Handle exceptions
* Print result messages



###### handleUserRequest(Long productId, int quantity)

* ✅ Order Confirmed (for success)
* ❌ ERROR: message (for failure)



#### System Bootstrapping (Main Class)



###### The system is initialized from bottom to top:

1. Create ProductRepository

2\. Inject into OrderService

3\. Inject into OrderController

4\. Call test scenario



###### Example scenario:

* orderController.handleUserRequest(1L, 2);



#### Conclusion

In this lab, a layered architecture was successfully implemented using Java. The system separates responsibilities into persistence, business, and presentation layers. Dependencies were managed using constructor injection, and the system was bootstrapped in the main class. The application correctly handles valid orders and insufficient stock scenarios, demonstrating proper separation of concerns and clean architecture design.

