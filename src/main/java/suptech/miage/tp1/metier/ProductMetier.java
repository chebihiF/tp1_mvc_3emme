package suptech.miage.tp1.metier;

import suptech.miage.tp1.dao.ProductDao;
import suptech.miage.tp1.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMetier implements IProductMetier{

    private ProductDao dao = new ProductDao();

    @Override
    public List<Product> getAll() throws Exception {
        return dao.getAll();
    }

    @Override
    public List<Product> getProductByLabel(String label) throws Exception {
        List<Product> products = dao.getAll();
        List<Product> products_byLabel = new ArrayList<>();
        for(Product product: products)
            if(product.getLabel().equals(label))
                products_byLabel.add(product);
        return products_byLabel;
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        if(!product.getRef().startsWith("R00"))
            throw new Exception("the product must start with R00");
        if(!product.getLabel().equals(product.getLabel().toUpperCase()))
            throw new Exception("Label must be uppercase");
        return dao.addProduct(product);
    }
}
