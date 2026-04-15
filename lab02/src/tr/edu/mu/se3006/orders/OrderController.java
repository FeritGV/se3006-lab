package tr.edu.mu.se3006.orders;

// PUBLIC: Entry point for the Orders context.
public class OrderController {
    
    // TODO: Define OrderService dependency and use Constructor Injection
    private final OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    public void handleUserRequest(Long productId, int quantity) {
        System.out.println(">>> New Request: Product ID=" + productId + ", Quantity=" + quantity);
        // TODO: Call placeOrder inside a try-catch block. 
        // Print "✅ Order Confirmed" on success, or "❌ ERROR: [message]" on failure.
        try{
            this.orderService.placeOrder(productId, quantity);
            System.out.println("✅ Order Confirmed");
        } catch(IllegalArgumentException e){
            System.out.printf("❌ ERROR: %s\n", e.getMessage());
        }
    }
}
