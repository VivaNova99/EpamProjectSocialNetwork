package model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Photo {

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private User user;
//    private int userId;
//    user_id INT NOT NULL,
    private PhotoAlbum album;
//    private int albumId;
//    album_id INT,
    private String picture;
//    picture VARCHAR(100) NOT NULL,
    private String description;
//    description VARCHAR(100),
    private LocalDateTime dateTime;
//    date_time DATETIME NOT NULL,
    private PhotoStatus status;
//    status_id INT,
//
//    FOREIGN KEY (user_id) REFERENCES User(id),
//    FOREIGN KEY (album_id) REFERENCES PhotoAlbum(id),
//    FOREIGN KEY (status_id) REFERENCES PhotoStatus(id)
}