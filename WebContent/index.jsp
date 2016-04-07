<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mortgage Calculator</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
 <body>
        <form action="mortgageservlet" method="post">
            <h1>Mortgage Calculator</h1>
            <p>
                <label for="principal">Enter the Principal:</label>
                <input id="principal" type=text name="principal" value="${principal}">
            </p>
            <p>
                <label for="rate">Enter the Annual Interest Rate:</label>
                <input id="rate" type="number" name="rate" value="${rate}">
            </p>
            <p>
                <label for="term">Enter the Loan Term in Years:</label>
                <input id="term" type="number" name="term" value="${term}">
            </p>
            <p>
                <input type="submit" value="Calculate">
            </p>
        </form>
        
  <c:choose>
    <c:when test="${calculated.equals('yes')}"><br>
 <%--   
        Principal = <c:out value="${ principal}" /><br>   
        Annual Interest Rate = <c:out value="${rate}" /> <br>
        Loan Years = <c:out value="${term }" /> <br>
 --%>       
        The monthly payment is: <c:out value="${payment}" />   
  </c:when>
  <c:otherwise>
  </c:otherwise>
  </c:choose>    
    </body>
</html>