package tr.edu.mu.se3006;
import tr.edu.mu.se3006.presentation.OrderController;
import tr.edu.mu.se3006.business.OrderService;
import tr.edu.mu.se3006.persistence.ProductRepository;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("🚀 System Starting...\n");
        ProductRepository productRepository = new ProductRepository();
        OrderService orderService = new OrderService(productRepository);
        OrderController orderController = new OrderController(orderService);
        
        System.out.println("--- Test Scenarios ---");
        orderController.handleUserRequest(1L, 2);
    }
}
