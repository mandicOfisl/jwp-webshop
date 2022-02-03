package hr.algebra.lmandic.webshop.servlet;

import hr.algebra.lmandic.webshop.model.Category;
import hr.algebra.lmandic.webshop.model.Product;
import hr.algebra.lmandic.webshop.repository.CategoryRepo;
import hr.algebra.lmandic.webshop.repository.ProductRepo;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductManagmentServlet", urlPatterns = {"/productManagment"})
public class ProductManagmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductRepo productRepo = new ProductRepo();
        CategoryRepo categoryRepo = new CategoryRepo();      
        
        String isDelete = request.getParameter("d");  
        
        if (isDelete != null) {
            Integer productId = Integer.parseInt(request.getParameter("id"));
            
            productRepo.delete(productId);
        }
        
        List<Product> products = productRepo.getProducts();
        List<Category> cats = categoryRepo.getCategories();
        
        
        request.getSession().setAttribute("categories", cats);
        request.getSession().setAttribute("products", products);
        
        response.sendRedirect("productManagment.jsp");
                
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductRepo productRepo = new ProductRepo();
        CategoryRepo categoryRepo = new CategoryRepo();
        
        List<Product> products = productRepo.getProducts();
        List<Category> cats = categoryRepo.getCategories();
        
        request.setAttribute("categories", cats);
        request.setAttribute("products", products);
          
        String isUpdate = request.getParameter("u");
        
        if (isUpdate != null) {
            Integer id = Integer.parseInt(request.getParameter("productId"));
            String name = request.getParameter("productName");
            Integer catId = Integer.parseInt(request.getParameter("categoryId"));
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            
            productRepo.update(id, name, catId, price);         
            
        }
                
        products = productRepo.getProducts();        
                
        request.getSession().setAttribute("products", products);   
        request.setAttribute("products", products);   
        
        request.getRequestDispatcher("productManagment.jsp").forward(request, response);
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
