package controllers;

import dto.MovieDTO;
import service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "UpdateMovieServlet",urlPatterns = "/Pages/admin/updateMovie")
public class UpdateMovieServlet extends HttpServlet {

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDTO movieDTO = MovieServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("movieDTO",movieDTO);
        request.getRequestDispatcher("updateMovie.jsp").forward(request,response);
    }
}
