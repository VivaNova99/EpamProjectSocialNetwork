<%@ page import="controllers.UserOwnPageController" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.WallMessage" %>
<%@ page import="model.Photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/user-page.css" %>
    </style>

</head>
<body>

<div class="user-page">

    <%
        User user = (User) request.getAttribute(UserOwnPageController.USER_INFO_KEY);
    %>

    <div class="user-profile-picture"><img src="users_profile_picture?user_id=<%=user.getId()%>" /></div>
    <br><a href="user-change-profile-photo-form.jsp">изменить фотографию профиля</a>

    <section class="user-info">
        <div class="user-name"><%=user.getFirstName()%> <%=user.getLastName()%></div>
        <div class="user-status-on-wall"><%=user.getStatusOnWall()%></div>
        <div class="user-dob">День рождения: <%=user.getDateOfBirth()%></div>
        <div class="user-city">Город: <%=user.getCity()%></div>
        <a href="user-change-info-form.jsp?id=<%=user.getId()%>&email=<%=user.getEmail()%>&first_name=<%=user.getFirstName()%>&last_name=<%=user.getLastName()%>&status=<%=user.getStatusOnWall()%>&dob=<%=user.getDateOfBirth()%>&city=<%=user.getCity()%>">редактировать информацию профиля</a>
    </section>

<%
    Collection<Photo> last5ForUserPhotos = (Collection<Photo>) request.getAttribute(UserOwnPageController.LAST_5_FOR_USER_PHOTOS_KEY);
%>

    <section class="user-photos">

        <h1 class="my-photos">Мои фотографии</h1>

        <ul>
            <%
                for (Photo last5ForUserPhoto: last5ForUserPhotos) {
            %>
            <li class="user-last-photo">
                <img src="photo_picture?photo_id=<%=last5ForUserPhoto.getId()%>">
            </li>
            <%
                }
            %>
        </ul>

    </section>


    <section class="wall-messages">
        <textarea class="whats-new" placeholder="Что у Вас нового?"></textarea>

<%
    Collection<WallMessage> last10ForUserWallMessages = (Collection<WallMessage>) request.getAttribute(UserOwnPageController.LAST_10_FOR_USER_WALL_MESSAGES_KEY);
%>

        <ul class="my-wall">
            <li class="my-notes"><h1>Мои записи</h1></li>
            <%
                for (WallMessage last10ForUserWallMessage: last10ForUserWallMessages) {
            %>
                <ul>
                    <li class="header">
                        <%=last10ForUserWallMessage.getMessageHeader()%>
                    </li>
                    <li class="date-time">
                        <%=last10ForUserWallMessage.getDateTime()%> Вы написали:
                    </li>
                    <li class="text">
                        <%=last10ForUserWallMessage.getText()%>
                    </li>
                    <li class="picture">
                        <img src="wall_message_picture?wall_message_picture_id=<%=last10ForUserWallMessage.getId()%>" />
                    </li>
                    <li class="link">
                        <a href="forum-this-topic?this_forum_topic_id=<%=last10ForUserWallMessage.getId()%>"> ссылка на обсуждение </a>
                    </li>
                </ul>
            <%
                }
            %>
        </ul>
    </section>

</div>
<%--<input type="hidden" name="j_id" value="<%=session.getAttribute("j_id")%>">--%>
<%--<input type="hidden" name="j_id" value="<%=request.getParameter("j_id")%>" />--%>

</body>
</html>
