package programmer.zaman.now.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] numbers = req.getParameterValues("number");
        int sum = Stream.of(numbers).mapToInt(value -> Integer.valueOf(value)).sum();
        resp.getWriter().print(sum);
    }
}
