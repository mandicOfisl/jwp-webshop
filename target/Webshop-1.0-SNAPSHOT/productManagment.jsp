<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tld/tagLib.tld" prefix="t" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="hr.algebra.lmandic.webshop.model.Product"%>
<%@page import="hr.algebra.lmandic.webshop.model.Category"%>
<jsp:useBean id="products" scope="session" type="java.util.List"/>
<jsp:useBean id="categories" scope="session" type="java.util.List"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage products</title>
        <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css"/>
        
        <script src="Resources/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="Resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <t:navbar />
        
        <div class="container">
            
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">New product</div>
                        <div class="card-body">
                            <form action="${contextPath}/productManagment" method="POST">
                                <label for="productName">Name</label>
                                <input class="form-control" type="text" name="productName" >
                                <label for="categoryId">Category</label>
                                <select  class="form-control" name="categoryId">
                                    <c:forEach items="${categories}" var="category">
                                        <option 
                                            value="${category.getId()}"> 
                                            ${category.name}
                                        </option>                             
                                    </c:forEach>
                                </select>
                                <label for="price">Name</label>
                                <input class="form-control" type="text" name="price" >
                                
                                <button 
                                    class="btn btn-success" 
                                    type="submit"
                                    style="width: 50%;"
                                    >
                                    Add new product
                                </button>
                                
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                        <div class="card-header">New category</div>
                        <div class="card-body">
                            <form action="${contextPath}/category" method="POST">
                            
                                <label for="categoryName">Name</label>
                                <input class="form-control" type="text" name="categoryName" >
                            
                                <button 
                                    class="btn btn-success" 
                                    type="submit"
                                    style="width: 50%;"
                                    >
                                    Add new categroy
                                </button>
                                
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
                            <div class="row" style="display: flex;">
                
                    <t:productEdit />
                
            </div>
            
        </div>     
        
        
    </body>
</html>
