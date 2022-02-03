package hr.algebra.lmandic.webshop.servlet;

import hr.algebra.lmandic.webshop.repository.CategoryRepo;
import hr.algebra.lmandic.webshop.repository.ProductRepo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hr.algebra.lmandic.webshop.model.Category;
import hr.algebra.lmandic.webshop.model.Product;
import hr.algebra.lmandic.webshop.model.ShoppingCart;
import javax.servlet.http.Cookie;


@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            CategoryRepo categoryRepo = new CategoryRepo();            
            List<Category> cats = categoryRepo.getCategories();
             
            ProductRepo repo = new ProductRepo();
            List<Product> products = repo.getProducts();        
                        
            request.getSession().setAttribute("categories", cats);
            request.getSession().setAttribute("products", products);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie cks[] = request.getCookies();
        Cookie roleCookie = null;
        
        for (Cookie cookie : cks) {
            if (cookie.getName().equals("role")) {
                roleCookie = cookie;
                break;
            }
        }    
        
        String withoutLogin = request.getParameter("logout");
            
        if (roleCookie == null 
                || roleCookie.getValue().equals("")
                || withoutLogin != null) {
            roleCookie = new Cookie("role", "");
            roleCookie.setMaxAge(3600);
            
            response.addCookie(roleCookie);
        }        
         
        if (request.getSession().getAttribute("cart") == null) {
            ShoppingCart cart = new ShoppingCart();        
            request.getSession().setAttribute("cart", cart);     
        }                        
        
        processRequest(request, response);

        response.sendRedirect("shopHome.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
