package controllers;

import dao.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static java.lang.Integer.parseInt;


@WebServlet("/user-photos-in-photoalbum")
public class UserPhotosInThisPhotoalbumController extends HttpServlet {

    public static final String WELCOME_KEY = "Welcome";
    public static final String ALL_USERS_KEY = "AllUser";
//    public static final String ALL_FORUM_THEMES_KEY = "AllForumThemes";
    public static final String ALL_PHOTO_ALBUMS_KEY = "AllPhotoAlbums";
    public static final String ALL_PHOTOS_KEY = "AllPhotos";
//    public static final String ALL_PRIVATE_MESSAGES_KEY = "AllPrivateMessages";
//    public static final String ALL_WALL_MESSAGES_KEY = "AllWallMessages";
    public static final String USER_PHOTOS_KEY = "UserPhotos";

    private UserDao userDao;
    private ForumThemeDao forumThemeDao;
    private PhotoAlbumDao photoAlbumDao;
    private PhotoDao photoDao;
    private PrivateMessageDao privateMessageDao;
    private WallMessageDao wallMessageDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = (UserDao) config.getServletContext().getAttribute("UserDao");
//        forumThemeDao = (ForumThemeDao) config.getServletContext().getAttribute("ForumThemeDao");
        photoAlbumDao = (PhotoAlbumDao) config.getServletContext().getAttribute("PhotoAlbumDao");
        photoDao = (PhotoDao) config.getServletContext().getAttribute("PhotoDao");
//        privateMessageDao = (PrivateMessageDao) config.getServletContext().getAttribute("PrivateMessageDao");
//        wallMessageDao = (WallMessageDao) config.getServletContext().getAttribute("WallMessageDao");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int userId;
        String photoalbumIdString = req.getParameter("photoalbum_id");
        int photoalbumId = parseInt(photoalbumIdString);

        boolean b = Optional.ofNullable(req.getSession().getAttribute(String.valueOf("email")))
                .map(o -> true)
                .orElse(false);

        if (b && !((session.getAttribute("email")).equals("null"))) {
            String email = String.valueOf(session.getAttribute("email"));

            userId = userDao.getUserId(email);

            req.setAttribute(ALL_USERS_KEY, userDao.getAll());
            req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
            req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
            req.setAttribute(USER_PHOTOS_KEY, photoDao.getUserPhotosInThisPhotoalbum(userId, photoalbumId));

            System.out.println("In UserPhotosController: user_id from getUserId(email) - " + userDao.getUserId(email) + ", " +
                    "user_id - " + session.getAttribute("user_id") + "," +
                    " email - " + session.getAttribute("email") + ", " +
                    "photoalbum_name - " + req.getParameter("photoalbum_name") + "," +
                    " description - " + req.getParameter("description"));

            req.getRequestDispatcher("reg-user-photos.jsp")
                    .forward(req, resp);
        }
        else {
            System.out.println("атрибут email из сессии куда-то потерялся/ или незарегистрированный пользователь");

            // пока что нет просмотра фотоальбомов незарегистрированным пользователем и этот параметр ниоткуда не приходит
            String someUserIdString = req.getParameter("some_user_id");
            int someUserId = parseInt(someUserIdString);

            req.setAttribute(ALL_USERS_KEY, userDao.getAll());
            req.setAttribute(ALL_PHOTO_ALBUMS_KEY, photoAlbumDao.getAll());
            req.setAttribute(ALL_PHOTOS_KEY, photoDao.getAll());
            req.setAttribute(USER_PHOTOS_KEY, photoDao.getUserPhotosInThisPhotoalbum(someUserId, photoalbumId));

            req.getRequestDispatcher("unreg-user-photos.jsp")
                    .forward(req, resp);
        }

    }
}