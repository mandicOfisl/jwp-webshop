package hr.algebra.lmandic.webshop.servlet;

import com.paypal.base.rest.PayPalRESTException;
import hr.algebra.lmandic.webshop.model.PaymentType;
import hr.algebra.lmandic.webshop.model.Product;
import hr.algebra.lmandic.webshop.model.ProductPurchase;
import hr.algebra.lmandic.webshop.model.Purchase;
import hr.algebra.lmandic.webshop.model.ShoppingCart;
import hr.algebra.lmandic.webshop.service.PaymentServices;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AuthorizePaymentServlet", urlPatterns = {"/authorizePayment"})
public class AuthorizePaymentServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
 
    public AuthorizePaymentServlet() {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        
        String paymentType = request.getParameter("paymentType");
        
        PaymentType pt = new PaymentType();
        pt.setName(paymentType);
        
        Purchase purchase = createNewPurchase(cart, pt);
        
        request.getSession().setAttribute("purchase", purchase);
        
        
        
        if (paymentType.equals("cash")) {
            
            
        } else {
            PaymentServices ps = new PaymentServices();
            try {
                response.sendRedirect(ps.authorizePayment(purchase));
            } catch (PayPalRESTException ex) {
                Logger.getLogger(AuthorizePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private Purchase createNewPurchase(ShoppingCart cart, PaymentType paymentType) {
        Purchase p = new Purchase();
        p.setAmount(cart.getTotalAmount().doubleValue());
        p.setPaymentType(paymentType);
        p.setPurchaseDate(Calendar.getInstance().getTime());
        
        for (Map.Entry<Product, Integer> en : cart.getItems().entrySet()) {
            Product key = en.getKey();
            Integer value = en.getValue();
            
            ProductPurchase pp = new ProductPurchase();
            pp.setProduct(key);
            pp.setAmount(value);
            
            //insertProductPurchase(pp);
            
            p.getProductPurchases().add(pp);            
        }
        
        return p;
    }

    private void insertProductPurchase(ProductPurchase pp) {
        
    }

}
