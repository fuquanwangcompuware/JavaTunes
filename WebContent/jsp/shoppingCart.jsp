<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!--

//-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link type="text/css" rel="stylesheet" href="stylesheet.css"/>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="script.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to JavaTunes</title>
</head>
<body>

<% 
	if(request.getSession().getAttribute("user")==null) {
		response.sendRedirect("login.do?msg=needLogin");
	} else {
%>

<%@ include file="/jsp/header.jspf" %>
<div id="logout"><a onclick="logout()"><img src='images/logout.jpg'/></a></div>
<hr/>
<p>
<h2><%=langMap.get("shoppingcart.yourshoppingcart")%></h2>

    <c:if test="${empty checkout.results}">
    	<%=langMap.get("shoppingcart.nothing")%>
    	<br>
    	<br>
    	<input type='button' value='<%=langMap.get("shoppingcart.searchandshop")%>' onclick="gotoPage('${pageContext.request.contextPath}/search.do')"/>
    </c:if>
    
    <c:if test="${not empty checkout.results}">
	<table border="1">
	  <thead>
	    <tr>
	      <th align='center' width='400'><%=langMap.get("shoppingcart.title")%></th>
	      <th align='center' width='300'><%=langMap.get("index.artist")%></th>
	      <th align='center'><%=langMap.get("shoppingcart.quantity")%></th>
	    </tr>
	  </thead>
	  <tbody>

		<c:forEach items="${checkout.results}" var="item">
	    <tr>
	      <td><c:out value="${item.itemName}"/></td>
	      <td><c:out value="${item.artist}"/></td>
	      <td align='center'><c:out value="${item.quantity}"/></td>
	    </tr>
       </c:forEach>
       
       <tr>
       	<td align='right' colspan='4'>
       		<strong>
       			<%=langMap.get("shoppingcart.pricebeforetax")%>: $<c:out value="${checkout.priceBeforeTax}"/>  <br>
       			<%=langMap.get("shoppingcart.tax")%>: $<c:out value="${checkout.tax}"/>  <br> 
       			<font size='12' color='green'>
       				<%=langMap.get("shoppingcart.totalprice")%>: $<c:out value="${checkout.totalPrice}"/>
       			</font>
       		</strong>
       	</td>
       </tr>
       
       <tr>
       	<td align='center' colspan='4'>
       		<input type='button' value='<%=langMap.get("shoppingcart.checkout")%>' onclick="confirmCheckingOut()"/>  
       		<input type='button' value='<%=langMap.get("shoppingcart.shopformore")%>' onclick="gotoPage('${pageContext.request.contextPath}/search.do')"/>
       	</td>
       </tr>
       
      </tbody>
	</table>
	</c:if>

<%} %>
</body>
</html>