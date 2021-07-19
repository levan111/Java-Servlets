package Controller;

import Entity.Cart;
import Entity.Product;
import Repository.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database data = (Database)req.getServletContext().getAttribute("database");
        String id = req.getParameter("productId");
        Cart mycart = (Cart)req.getSession().getAttribute("mycart");
        try {
            if(id != null)mycart.addToCart(data.getProduct(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/myCart.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart mycart = (Cart)req.getSession().getAttribute("mycart");
        Database data = (Database)req.getServletContext().getAttribute("database");
        List<String> elems = Collections.list(req.getParameterNames());
        for(String id : elems){
            try {
                mycart.addToCart(data.getProduct(id),Integer.parseInt(req.getParameter(id)));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        req.getRequestDispatcher("/WEB-INF/myCart.jsp").forward(req,resp);
    }

}
