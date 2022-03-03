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
            req.getRequestDispatcher("WEB-INF/views/products.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
