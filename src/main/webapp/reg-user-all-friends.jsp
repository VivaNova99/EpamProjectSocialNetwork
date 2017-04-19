<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.MyFriendsController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: veraivanova
  Date: 11.04.17
  Time: 7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Добро пожаловать</title>
</head>
<body>

<header class="reg-user">
    <%@ include file="WEB-INF/header-reg-user.jsp" %>
</header>

<aside class="reg-user">
    <%@ include file="WEB-INF/sidebar-reg-user.jsp" %>
</aside>

<section>

    <%
        Collection<User> friends = (Collection<User>) request.getAttribute(MyFriendsController.ALL_FRIENDS_KEY);
    %>

    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Profile photo</th>
            <th>Status on wall</th>
        </tr>
            <%
        for (User friend: friends) {
    %>
        <tr>
            <td><%=friend.getFirstName()%></td>
            <td><%=friend.getLastName()%></td>
            <td><%=friend.getProfilePhoto()%></td>
            <td><%=friend.getStatusOnWall()%></td>
        </tr>
            <%
        }
    %>


</section>

</body>
</html>
