package controllers;

import dto.MovieDTO;
import service.impl.MovieServiceImpl;

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
@WebServlet(name = "ThxForAddMovieServlet",urlPatterns = "/thxForAddMovie")
public class ThxForAddMovieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String genre = request.getParameter("genre");
        int rating = Integer.parseInt(request.getParameter("rating"));
        LocalDate rentStart = LocalDate.of(Integer.parseInt(request.getParameter("syear")),
                Integer.parseInt(request.getParameter("smonth")), Integer.parseInt(request.getParameter("sday")));
        LocalDate rentEnd = LocalDate.of(Integer.parseInt(request.getParameter("eyear")),
                Integer.parseInt(request.getParameter("emonth")), Integer.parseInt(request.getParameter("eday")));

        MovieServiceImpl.getInstance().save(new MovieDTO(title,description,duration,rentStart,rentEnd,genre,rating));
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }
}
