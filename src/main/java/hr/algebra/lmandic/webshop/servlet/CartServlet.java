/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.servlet;

import hr.algebra.lmandic.webshop.model.Product;
import hr.algebra.lmandic.webshop.model.ShoppingCart;
import hr.algebra.lmandic.webshop.repository.ProductRepo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author C
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                                        
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        
        if (cart == null) cart = new ShoppingCart();
        
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        
        ProductRepo productRepo = new ProductRepo();
        
        Product product = productRepo.getProductById(productId);
        
        cart.put(product, quantity);
        
        request.getSession().setAttribute("cart", cart);
        
        response.sendRedirect(request.getRequestURL().toString());
        
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
