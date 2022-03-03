package suptech.miage.tp1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import suptech.miage.tp1.entities.Product;
import suptech.miage.tp1.util.HibernateUtil;

import java.util.List;

public class ProductDao implements IProductDao{

    private SessionFactory factory = HibernateUtil.getFactory();

    @Override
    public List<Product> getAll() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product p",Product.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return products;
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        String ref = (String) session.save(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }
}
