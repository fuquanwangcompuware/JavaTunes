<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--

//-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/jsp/header.jspf" %>
<link type="text/css" rel="stylesheet" href="stylesheet.css"/>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="script.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to JavaTunes</title>
</head>
<body onload="hideProcessing()">

<%
	if (request.getSession().getAttribute("user") == null) {
		response.sendRedirect("login.do?msg=needLogin");
	} else {
%>

<div id="cart_index"><a href="${pageContext.request.contextPath}/checkout.do"><img src='images/cart.jpg'/></a></div>
<div id="logout_index"><a onclick="logout()"><img src='images/logout.jpg'/></a></div>

<hr/>
<p>
<h2><font color='Blue'><%=langMap.get("index.seebelow")%> <br><br>Or </font><a href="${pageContext.request.contextPath}/search.do"><%=langMap.get("index.searchfortunes")%></a></h2>

	<c:if test="${empty login.results}">
    	No records found ...
    </c:if>
    
    <c:if test="${not empty login.results}">
	<table border="1">
	  <thead>
	    <tr>
	      <th><%=langMap.get("index.id")%></th>
	      <th><%=langMap.get("index.name")%></th>
	      <th><%=langMap.get("index.artist")%></th>
	      <th><%=langMap.get("index.releasedate")%></th>
	      <th><%=langMap.get("index.listprice")%></th>
	      <th><font color='green'><%=langMap.get("index.yourprice")%></font></th>
	      <th><%=langMap.get("index.action")%></th>
	    </tr>
	  </thead>
	  <tbody>

       <c:forEach items="${login.results}" var="item">
	    <tr>
	      <!-- We use both getProperty and c:out here to illustrate -->
	      <!-- their use                                            -->
	      <td><c:out value="${item.id}"/></td>
	      <td><c:out value="${item.title}"/></td>
		  <td><c:out value="${item.artist}"/></td>
	      <td><fmt:formatDate value="${item.releaseDate}" type="date" dateStyle="medium"/></td>
	      <td>$<c:out value="${item.listPrice}"/></td>
	      <td><b><font color='green'>$<c:out value="${item.price}"/></font></b></td>
	      <td align='center'>
	      	<div id='addToCartRecord${item.id}'>
	      		<input type='button' id='addToCartButton${item.id}' onclick="processClick(${item.id})" value='<%=langMap.get("index.addtocart")%>'/>
	      	</div>
	      	<div id='processing${item.id}' class='processing'><img src='images/processing.gif'/></div>
	      </td>
	    </tr>
       </c:forEach>
       
      </tbody>
	</table>
	</c:if>
	
	<%} %>
</body>
</html>