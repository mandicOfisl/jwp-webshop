<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="hr.algebra.lmandic.webshop.model.UserLogin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tld/tagLib.tld" prefix="t" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User logins</title>
        <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css"/>        
        <script src="Resources/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="Resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <t:navbar />
        
        <div class="container">
            
            <h3>User logins</h3>
            
            <div class="card" style="width: 680px; height: 420px; overflow: auto;">
                <div class="card-header">
                    <div class="row">
                        <div class="col">Username</div>
                        <div class="col">ip address</div>
                        <div class="col">Date and time</div>
                    </div>
                </div>
                <div class="card-body" style="overflow: auto;">

                    <c:forEach items="${userLogins}" var="ul">

                        <div class="row">

                            <div class="col">
                                ${ul.getUserAccount().getUsername()}
                            </div>

                            <div class="col">
                                ${ul.getIpAddress()}
                            </div>

                            <div class="col">
                                ${ul.getUserLoginDate()}
                            </div>

                        </div>

                    </c:forEach>
                </div>
                
            </div>
        </div>
        
    </body>
</html>
