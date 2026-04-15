# SE3006 - Lab 2 Report: Modular Monolith Architecture

## Objective

The aim of this lab is to design and implement a modular monolith architecture in Java. In the previous lab, a layered architecture was used where components were separated into presentation, business, and persistence layers. In this lab, the focus shifts to a more structured approach by introducing clear module boundaries, better encapsulation, and controlled communication between parts of the system.

The system is divided into two main modules: the Catalog module and the Orders module. Each module is responsible for its own functionality and hides its internal implementation details, exposing only a public interface to the outside.

## System Architecture

The Catalog module is responsible for managing products and their stock. It exposes a single public interface called `CatalogService`, which provides the method `checkAndReduceStock`. This is the only part of the module that other modules are allowed to access. All other classes inside the Catalog module, such as `CatalogServiceImpl`, `ProductRepository`, and `Product`, are kept package-private. This means they are hidden and cannot be accessed directly from outside the module. The module also uses a factory class, `CatalogFactory`, to create and connect its internal components and return a ready-to-use service.

The Orders module is responsible for handling order operations. The main entry point of this module is the `OrderController`, which receives user requests and communicates with the business logic. Internally, the module includes `OrderService`, `OrderRepository`, and the `Order` class. Unlike the Catalog module, the Orders module depends on the Catalog module, but only through the `CatalogService` interface. This ensures that the Orders module does not directly interact with the internal details of the Catalog module. Similar to the Catalog module, a factory class called `OrdersFactory` is used to create and wire all necessary components.

The interaction between modules is strictly controlled. The Orders module communicates with the Catalog module only through the `CatalogService` interface. This design prevents direct access to internal classes and enforces a clear separation between modules.

## Dependency Injection and Factories

Dependency injection is used throughout the system, specifically constructor injection. Each component receives its dependencies through its constructor rather than creating them internally. For example, `CatalogServiceImpl` receives a `ProductRepository`, and `OrderService` receives both a `CatalogService` and an `OrderRepository`. This approach makes the system easier to test and maintain.

Factories play an important role in this architecture. Instead of creating objects manually in different parts of the code, factories handle the creation and wiring of components. This keeps object creation centralized and prevents other parts of the system from depending on internal classes.

## System Execution

The application starts in the `Main` class. First, the Catalog module is created using `CatalogFactory`. Then, the Orders module is created using `OrdersFactory`, which receives the Catalog service as a dependency. After everything is set up, the system is tested by calling the `handleUserRequest` method through the controller.

When a valid request is made, the system reduces the stock and confirms the order. If the requested quantity exceeds the available stock, an error message is displayed.

## Comparison with Lab 1

In Lab 1, the system was built using a layered architecture. Although this approach is simple and easy to understand, all classes are generally accessible across layers. This can lead to tight coupling, where changes in one part of the system may affect others. Adding new components is straightforward, but as the system grows, it becomes harder to manage and maintain.

In contrast, Lab 2 introduces a modular monolith architecture, where the system is divided into independent modules with clearly defined boundaries. Each module controls its own internal structure and exposes only what is necessary. This makes the system more robust and easier to extend. When adding a new component, developers must respect module boundaries, which may require more initial effort but results in a cleaner and safer design.

There are trade-offs between the two approaches. The layered architecture is simpler and quicker to implement, making it suitable for small projects. However, it lacks strong encapsulation. The modular monolith architecture introduces more structure and slightly more complexity, but it provides better maintainability, scalability, and flexibility in the long run.

## Conclusion

This lab demonstrates how a modular monolith architecture can improve the design of a system compared to a basic layered approach. By separating the system into modules, hiding internal implementations, and using interfaces and factories, the system becomes more organized and easier to manage. Although it requires more careful design, especially when adding new features, it provides clear benefits in terms of maintainability and scalability.
