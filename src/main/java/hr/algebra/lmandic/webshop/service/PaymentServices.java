package hr.algebra.lmandic.webshop.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import hr.algebra.lmandic.webshop.model.ProductPurchase;
import hr.algebra.lmandic.webshop.model.Purchase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentServices {
    
    private static final String CLIENT_ID =
            "Ae7dncPmouKVTypIMDBvn0m68npK-W1UIlQ7JoBKASBYAqpUUYupIQl-J4MI7ChoHSogqVfnGiw8N4Hi";
    private static final String CLIENT_SECRET =
            "EIYUGZXWS39NcjIXrj1r-KzHaOqTwvOJieQPA3f-EmBkBSShE_tIGRAShY3TMp_4dagRM__BtyEJ8cqN";
    private static final String MODE = "sandbox";
    
    public String authorizePayment(Purchase purchase)        
            throws PayPalRESTException {       
 
        Payer payer = getPayerInformation(); 
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(purchase);
         
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment approvedPayment = requestPayment.create(apiContext);
 
        return getApprovalLink(approvedPayment);
 
    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("William")
                 .setLastName("Peterson")
                 .setEmail("william.peterson@company.com");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        
        redirectUrls.setCancelUrl("https://jwp-webshop.herokuapp.com/shopHome.jsp");
        redirectUrls.setReturnUrl("https://jwp-webshop.herokuapp.com/shopHome.jsp");

        return redirectUrls;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
    String approvalLink = null;
     
    for (Links link : links) {
        if (link.getRel().equalsIgnoreCase("approval_url")) {
            approvalLink = link.getHref();
            break;
        }
    }      
     
    return approvalLink;
    }

    private List<Transaction> getTransactionInformation(Purchase purchase) {
          
        Details details = new Details();
        details.setShipping("0");
        details.setSubtotal(String.valueOf(purchase.getAmount()));
        details.setTax("0");

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(String.valueOf(purchase.getAmount()));
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Duchan websop purchase");

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
        
        for (ProductPurchase pp : purchase.getProductPurchases()){
            Item item = new Item();
            item.setCurrency("USD");
            item.setName(pp.getProduct().getName());
            item.setPrice(pp.getProduct().getPrice().multiply(new BigDecimal(pp.getAmount())).toString());
            item.setTax("0");
            item.setQuantity(String.valueOf(pp.getAmount()));
            
            items.add(item);
        }
        
        itemList.setItems(items);
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);  

        return listTransaction;
    }
    
    
    
    
}
