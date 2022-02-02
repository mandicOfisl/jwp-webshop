package hr.algebra.lmandic.webshop.servlet;

import hr.algebra.lmandic.webshop.model.ShoppingCart;
import hr.algebra.lmandic.webshop.model.UserAccount;
import hr.algebra.lmandic.webshop.model.UserLogin;
import hr.algebra.lmandic.webshop.repository.UserLoginRepo;
import hr.algebra.lmandic.webshop.repository.UserRepo;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserRepo userRepo = new UserRepo();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
                
        UserAccount user = userRepo.getUserByName(username);
        
        if (user != null) {
            if (user.getPassword().equals(password)) {
                                
                logUserLogin(user, Calendar.getInstance().getTime(), getIpAddress(request));
                
                request.getSession().setAttribute("cart", new ShoppingCart());
                
                Cookie ck = new Cookie("username", username);
                ck.setMaxAge(3600);
                
                response.addCookie(ck);
                
                //log
                response.sendRedirect("home");
            }
        } else {
            response.sendError(403);
        }
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

    private void logUserLogin(UserAccount user, Date time, String remoteAddr) {
        UserLoginRepo ulr = new UserLoginRepo();
        
        UserLogin ul = new UserLogin();
        ul.setUserAccount(user);
        ul.setUserLoginDate(time);
        ul.setIpAddress(remoteAddr);
        
        ulr.insertUserLogin(ul);        
    }

    private String getIpAddress(HttpServletRequest request) {
        String addr = request.getHeader("X-FORWARDED-FOR");
        if (addr == null || "".equals(addr)) {
            addr = request.getRemoteAddr();
        }
        return addr;
    }

}
