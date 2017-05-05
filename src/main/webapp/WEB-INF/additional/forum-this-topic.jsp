<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="controllers.ForumThemeController" %>
<%@ page import="model.*" %>
<%@ page import="java.util.Collection"%>
<%@ page import="controllers.ForumTopicController" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Spirax">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        <%@include file="../../styles/main.css" %>
        <%@include file="../../styles/forum-this-topic.css" %>
    </style>

</head>

<body>

<section class="forum-this-topic">

    <%
        Collection<WallMessage> thisTopicWallMessages = (Collection<WallMessage>) request.getAttribute(ForumTopicController.THIS_TOPIC_WALL_MESSAGES_KEY);
        String subforumName = null;
        String topicName = null;
    %>

    <ul>
        <%
            for (WallMessage thisTopicWallMessage: thisTopicWallMessages) {
        %>
        <li>
            <ul>
                <li class="date-time"><%=thisTopicWallMessage.getDateTime()%></li>
                <li><a href="smb-page?some_user_id=<%=thisTopicWallMessage.getSenderUserId()%>">
                    <img src="users_profile_picture?user_id=<%=thisTopicWallMessage.getSenderUserId()%>" /></a></li>
                <li><a href="smb-page?some_user_id=<%=thisTopicWallMessage.getSenderUserId()%>">
                    <%=thisTopicWallMessage.getSenderUserFirstNameAndLastName()%></a>
                    <%=thisTopicWallMessage.getDateTime()%></li>
                <li><%=thisTopicWallMessage.getText()%></li>
                <li class="picture"><img src="wall_message_picture?wall_message_picture_id=<%=thisTopicWallMessage.getId()%>" /></li>
            </ul>

        </li>
        <%
                subforumName = thisTopicWallMessage.getForumThemeName();
                topicName = thisTopicWallMessage.getMessageHeader();
            }
        %>

        <li class="forum-theme"><p1><%=subforumName%></p1></li>
        <li class="forum-theme"><p2><%=topicName%></p2></li>

    </ul>

</section>

</body>
</html>
