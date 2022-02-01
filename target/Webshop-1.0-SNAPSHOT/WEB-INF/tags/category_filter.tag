<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="categories" required="true" rtexprvalue="true" type="java.util.List"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div>
    <div class="dropdown">
        <button 
            class="btn btn-primary dropdown-toggle" 
            type="button" 
            id="btnDropdown" 
            data-toggle="dropdown" 
            aria-haspopup="true" 
            aria-expanded="false">
                Choose category...
        </button>
        <div class="dropdown-menu" aria-labelledby="btnDropdown">
            <c:forEach items="${categories}" var="category">
                <a 
                    class="dropdown-item" 
                    href="${contextPath}/product?cat=${category.id}"
                    >
                    ${category.name}
                </a>
            </c:forEach>
        </div>
    </div>
</div>
    