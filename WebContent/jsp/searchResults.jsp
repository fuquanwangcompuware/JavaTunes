<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<HTML>
   <HEAD>
      <TITLE>Search Results</TITLE>
      <script src="http://code.jquery.com/jquery-latest.min.js"></script>
      <script type="text/javascript" src="script.js"></script>
   </HEAD>
   <BODY>
   
   <% 
	if(request.getSession().getAttribute("user")==null) {
		response.sendRedirect("login.do?msg=needLogin");
	} else {
%>
   
      <%@ include file="/jsp/searchHeader.jspf" %>
      <div id="cart"><a href="${pageContext.request.contextPath}/checkout.do"><img src='images/cart.jpg'/></a></div>
      <div id="logout"><a onclick="logout()"><img src='images/logout.jpg'/></a></div>
      <%=langMap.get("searchresult.searchresult")%> <B><c:out value='${param.keyword}'/></B>:
      <BR/>
    <c:if test="${empty search.results}">
    	No records found on given searching criteria ...
    </c:if>
    
    <c:if test="${not empty search.results}">
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

		<c:forEach items="${search.results}" var="item">
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
	      </td>
	    </tr>
       </c:forEach>
       
      </tbody>
	</table>
	</c:if>
	
	<%} %>
   </BODY>
</HTML>
