package Filters;


import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

//@WebFilter("/*")
public class SessionFilter implements HttpFilter {

//    private static String KEY = "key";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

//        String jUserLogin = request.getParameter("j_username");
//        String jUserPassword = request.getParameter("j_password");
//        String jUserId = request.getParameter("j_id");

//        session.setAttribute("j_id", jUserId);
//        //пока не работает
//        session.setAttribute("j_username", jUserLogin);
//        //пока не работает
//        session.setAttribute("j_password", jUserPassword);
//        //пока не работает

        //        посмотреть, что создается кука с идентификатором сессии
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + " - " + cookie.getValue());
        }

        System.out.println("parameter j_id in session = " + request.getParameter("j_id"));
        System.out.println("parameter j_username in session = " + request.getParameter("j_username"));
        System.out.println("parameter j_password in session = " + request.getParameter("j_password"));


        chain.doFilter(request, response);

//        if (session.getAttribute(KEY) != null) {
//            chain.doFilter(request, response);
//        }
//
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        if (parameterMap.containsKey("j_password") && parameterMap.containsKey("j_username")) {
//            // TODO: 22/10/2016

//            Optional<User> authorize = authorize(parameterMap);
//            if (authorize.isPresent()) {
//                session.setAttribute(KEY, authorize.get());
//                chain.doFilter(request, response);
//            } else
//                request.getRequestDispatcher("/error.html").forward(request, response);

//        } else {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
//            // TODO: 22/10/2016 посмотреть что можно сделать что бы не терять информацию о странице куда пользователь зашёл
//            requestDispatcher.forward(request, response);
//        }
    }
}