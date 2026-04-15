package tr.edu.mu.se3006.orders;
import tr.edu.mu.se3006.catalog.CatalogService;

class OrderService {
    // TODO: Define CatalogService and OrderRepository dependencies
    private final CatalogService catalogService;
    private final OrderRepository orderRepo;
    
    
    // TODO: Implement Constructor Injection
    OrderService(CatalogService service, OrderRepository repo){
        this.catalogService = service;
        this.orderRepo = repo;

    }
    
    void placeOrder(Long productId, int quantity) {
        // TODO 1: Call catalogService to check and reduce stock
        this.catalogService.checkAndReduceStock(productId, quantity);

        // TODO 2: If successful, create a new Order and save it via OrderRepository
        Order order = new Order(productId, quantity);
        this.orderRepo.save(order);
    }
}
