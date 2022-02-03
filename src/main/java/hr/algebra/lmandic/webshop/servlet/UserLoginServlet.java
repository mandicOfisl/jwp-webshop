package hr.algebra.lmandic.webshop.servlet;

import hr.algebra.lmandic.webshop.model.UserLogin;
import hr.algebra.lmandic.webshop.repository.UserLoginRepo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "UserLoginServlet", urlPatterns = {"/userLogin"})
public class UserLoginServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cks[] = request.getCookies();
        
        String role = "";
        String id = "";
        
        for (Cookie c : cks) {
            if (c.getName().equals("role")) {
                role = c.getValue();                
            }
            if (c.getName().equals("idUser")) {
                id = c.getValue();                
            }
        }
        
        UserLoginRepo ulr = new UserLoginRepo();
        
        List<UserLogin> userLogins = role.equals("admin") ?
                ulr.getUserLogins() : ulr.getUserLoginsByUserId(Integer.parseInt(id));
        
        request.setAttribute("userLogins", userLogins);
        request.getRequestDispatcher("userLogins.jsp").forward(request, response);                
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
