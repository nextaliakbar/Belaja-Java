package programmer.zaman.now.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("name");
        String cookieValue = req.getParameter("value");

        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");

        resp.addCookie(cookie);
        cookie.setMaxAge(-1);
        resp.getWriter().println("Sukses add cookie : " + cookieName + " : " + cookieValue);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                resp.getWriter().println("Cookie : " + cookie.getName() + " : " + cookie.getValue());
            }
        }
    }
}
