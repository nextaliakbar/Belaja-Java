package programmer.zaman.now.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

    private final AtomicLong counter = new AtomicLong(0);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long total = counter.getAndIncrement();

        String respon = "Total counter : " + total;

        resp.getWriter().println(respon);
    }
}
