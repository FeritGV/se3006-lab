package tr.edu.mu.se3006.business;
import tr.edu.mu.se3006.domain.Product;
import tr.edu.mu.se3006.persistence.ProductRepository;

public class OrderService {
    private ProductRepository repo;
    
    public OrderService(ProductRepository productRepository){
        this.repo = productRepository;
    }
    
    public void placeOrder(Long productId, int quantity) {
        Product product = repo.findById(productId);
        if (product.getStock() < quantity){
            throw new IllegalArgumentException("Not enough items in stock");
        }
        product.setStock(product.getStock() - quantity);
        repo.save(product);
    }
}
