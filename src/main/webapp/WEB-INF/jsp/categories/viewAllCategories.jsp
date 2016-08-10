<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View All Categories</title>
</head>
<body>
<h1>View All Categories</h1>
<br><br>
<table>
    <tr>
        <th>Category Id</th>
        <th>Category Title</th>
        <th>Category Description</th>
        <th>View Games in This Category</th>
        <%--ADD SCRIPT HERE--%>
    </tr>
    <c:forEach var="category" items="${categories}" >
        <tr>
            <td><a href="/categories/viewCategory?categoryId=${category.categoryId}"><c:out value="${category.categoryId}" /></a></td>
            <td><c:out value="${category.categoryTitle}" /></td>
            <td><c:out value="${category.categoryDescription}" /></td>
            <td><a href="/games/viewGamesInCategory?categoryId=${category.categoryId}">View  all Games</a></td>
            <%--ADD SCRIPT HERE--%>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/categories/addCategory">Add New Category</a>
</body>
</body>
</html>