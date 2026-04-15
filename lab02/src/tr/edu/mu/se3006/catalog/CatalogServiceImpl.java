package tr.edu.mu.se3006.catalog;

// Package-private implementation. Hidden from the outside world.
class CatalogServiceImpl implements CatalogService {
    
    // TODO: Define ProductRepository dependency
    private final ProductRepository repo;
    
    // TODO: Implement Constructor Injection
    CatalogServiceImpl(ProductRepository repo){
        this.repo = repo;
    }
    
    @Override
    public void checkAndReduceStock(Long productId, int quantity) {
        // TODO 1: Find product via repository
        Product product = this.repo.findById(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }

        // TODO 2: Check stock (throw IllegalArgumentException if insufficient)
        if (product.getStock() < quantity){
            throw new IllegalArgumentException("insufficient quantity");
        }

        // TODO 3: Reduce stock
        product.setStock(product.getStock() - quantity);

        // TODO 4: Save updated product
        this.repo.save(product);
    }
}
