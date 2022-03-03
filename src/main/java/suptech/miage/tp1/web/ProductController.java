package suptech.miage.tp1.web;

import suptech.miage.tp1.entities.Product;
import suptech.miage.tp1.metier.ProductMetier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private ProductMetier metier;

    @Override
    public void init() throws ServletException {
        metier = new ProductMetier();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> products = metier.getAll();
            req.setAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error",e.getMessage());
        }finally{
            req.getRequestDispatcher("WEB-INF/views/products.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ref = req.getParameter("reference");
        String label = req.getParameter("label");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        try {
            metier.addProduct(new Product(ref, label, price, quantity));
            List<Product> products = metier.getAll();
            req.setAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error",e.getMessage());
        }finally{
            req.getRequestDispatcher("WEB-INF/views/products.jsp").forward(req,resp);
        }


    }
}
