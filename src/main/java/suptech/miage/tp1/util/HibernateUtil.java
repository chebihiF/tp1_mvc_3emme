package suptech.miage.tp1.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import suptech.miage.tp1.entities.Product;

public class HibernateUtil {
    private static final SessionFactory factory;
    static {
        factory = new Configuration().configure()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }
    public static SessionFactory getFactory() {
        return factory;
    }
}
