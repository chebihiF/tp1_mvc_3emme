package suptech.miage.tp1.metier;

import suptech.miage.tp1.entities.Product;

import java.util.List;

public interface IProductMetier {
    public List<Product> getAll() throws Exception;
    public List<Product> getProductByLabel(String label) throws Exception;
    public Product addProduct(Product product) throws Exception;
}
