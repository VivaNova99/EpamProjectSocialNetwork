package model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class WallMessages {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private User senderUserId;
//    sender_user_id int NOT NULL,
    private User recieverUserId;
//    reciever_user_id int NOT NULL,
    private String text;
//    text VARCHAR(500) NOT NULL,
    private String picture;
//    picture VARCHAR(100) NOT NULL,
    private LocalDateTime dateTime;
//    date_time DATETIME NOT NULL,
    private ForumThemes forumThemesId;
//    forum_themes_id INT,
    private WallMessages parentMessageId;
//    parent_message_id INT,
    private MessagesStatus status;
//    status_id INT,
//
//    FOREIGN KEY (parent_message_id) REFERENCES WallMessages(id),
//    FOREIGN KEY (status) REFERENCES MessagesStatus(id)
//    FOREIGN KEY (forum_themes_id) REFERENCES ForumThemes(id)
}
