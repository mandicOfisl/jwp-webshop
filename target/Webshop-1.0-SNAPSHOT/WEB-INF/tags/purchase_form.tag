<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%-- any content can be specified here e.g.: --%>
<form action="${contextPath}/authorizePayment" method="POST">

    <label for="fullname" id="labelFullname">
        Full name
    </label>
    <input type="text"
           class="form-control"
           name="fullname"
           id="txtFullname">
    
    <label for="fullname" id="labelEmail">
        Email
    </label>
    <input type="email"
           class="form-control"
           name="email"
           id="txtEmail">
    
    <label for="address" id="labelAddress">
        Address
    </label>
    <input type="text"
           class="form-control"
           name="address"
           id="txtAddress">
    
    <label for="city" id="labelCity">
        City
    </label>
    <input type="text"
           class="form-control"
           name="city"
           id="txtCity">
    
    <label for="state" id="labelState">
        State
    </label>
    <input type="text"
           class="form-control"
           name="state"
           id="txtstate">
           
    <label for="paymentType">Payment type</label>
    <select class="form-control" id="selPayType" name="paymentType">
        <option value="cash">Cash</option>
        <option value="paypal">PayPal</option>
    </select>

    <button type="submit"
            class="btn btn-warning">
        Proceed
    </button>


</form>