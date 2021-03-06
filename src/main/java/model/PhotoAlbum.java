package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PhotoAlbum {

    public static String ID_KEY = "photoalbum_id";

    public int getId(){
        return id;
    }

    private int id;
    private String name;
    private User user;
    private Blob albumPicture;
    private String description;
    private Date dateTime;
    private PhotoStatus status;

    //                Для выгрузки фотографий из базы данных при помощи временных файлов
//    private String pathToFile;

    public PhotoAlbum(String name) {

        this.name = name;
    }


    public String getDateTime() {
        try {
            return new SimpleDateFormat("dd.MM.yyyy hh:mm").format(this.dateTime);
        }
        catch (NullPointerException e) {
            return "Дата и время не определены";
        }
    }

    public String getUserFirstNameAndLastName(){

        return user.getFirstNameAndLastName();

    }

    //для проверки, что подстановка метода в путь в jsp работает
//    public String getFakePath(String param) {
//        return param;
//    }
}
