<%@tag import="org.hibernate.Hibernate"%>
<%@tag import="hr.algebra.lmandic.webshop.model.Category"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="" pageEncoding="UTF-8"%>

<%@ attribute name="products" required="true" rtexprvalue="true" type="java.util.List" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:forEach items="${products}" var="product">
    <div class="col-4" style="margin: 16px 0">
        <form action="${contextPath}/cart" method="POST">
            <div class="card card-body projectCard">
                <input type="hidden" name="productId" value="${product.id}">

                <h2>${product.name}</h2>

                <p>${Hibernate.unproxy(product.getCategory()).getName()}</p>
                <p><b>${product.price} kn</b></p>

                <div style="display: flex; margin: 4px 0; justify-content: space-around;">
                    <p>
                    Količina:     
                    </p>
                    <input 
                        class="form-control" 
                        name="quantity"
                        value="1"
                        type="number" 
                        min="1"
                        style="width: 25%">
                </div>

                <button 
                    class="btn btn-primary" 
                    type="submit"
                    style="width: 50%;"
                    >
                    Add to Cart
                </button>          
            </div>
        </form>
    </div>
</c:forEach>
