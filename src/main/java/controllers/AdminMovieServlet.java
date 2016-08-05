package controllers;

import dto.MovieDTO;
import service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "AdminMovieServlet", urlPatterns = "Pages/admin/adminMovie")
public class AdminMovieServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MovieDTO> movieDTOList = MovieServiceImpl.getInstance().getAll();
        request.setAttribute("movieDTOList",movieDTOList);
        request.getRequestDispatcher("adminMovie").forward(request,response);
    }
}
