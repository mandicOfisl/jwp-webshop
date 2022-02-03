<%@tag import="hr.algebra.lmandic.webshop.model.Category"%>
<%@tag import="hr.algebra.lmandic.webshop.model.Product"%>
<%@tag import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="" pageEncoding="UTF-8"%>

<jsp:useBean id="products" scope="session" type="java.util.List"/>
<jsp:useBean id="categories" scope="session" type="java.util.List"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:forEach items="${products}" var="product">
<div class="card productCard" style="width: 360px;">
    <div class="card-header"></div>
    <div class="card-body">
        <form action="${contextPath}/productManagment?u=1" method="POST">    

            <input type="hidden" name="productId" value="${product.id}">

            <input class="form-control" type="text" name="productName" value="${product.getName()}" >

            <label for="categoryId">Category</label>
            <select  class="form-control" name="categoryId">
                <c:forEach items="${categories}" var="category">
                    <option 
                        value="${category.getId()}">                        
                        ${category.getName()}
                    </option>                             
                </c:forEach>
            </select>
            
            <div style="display: flex; margin: 4px 0; justify-content: space-around;">
                <p>
                    Cijena     
                </p>
                <input 
                    class="form-control" 
                    name="price"
                    value="${product.getPrice()}"
                    type="text"
                    style="width: 25%">
            </div>

            <button 
                class="btn btn-primary" 
                type="submit"
                style="width: 50%;"
                >
                Update
            </button>    
        </form>
    </div>
    <div class="card-footer">
        <a 
            class="btn btn-danger" 
            href="${contextPath}/productManagment?d=1&id=${product.getId()}">
            Delete
        </a>
    </div>
</div>
 
</c:forEach>