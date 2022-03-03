package suptech.miage.tp1.dao;

import suptech.miage.tp1.entities.Product;
import java.util.List;

public interface IProductDao {
    public List<Product> getAll() throws Exception;
    public Product addProduct(Product product) throws Exception;
}
