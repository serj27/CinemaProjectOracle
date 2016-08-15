package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "ThxForAddSessionServlet",urlPatterns = "/thxForAddSession")
public class ThxForAddSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int movieID = Integer.parseInt(request.getParameter("movie_id"));
        int hallID = Integer.parseInt(request.getParameter("hall_id"));
        LocalDate startTime = LocalDate.of(Integer.parseInt(request.getParameter("syear")),
                Integer.parseInt(request.getParameter("smonth")), Integer.parseInt(request.getParameter("sday")));
        double price = Integer.parseInt(request.getParameter("price"));

        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}
