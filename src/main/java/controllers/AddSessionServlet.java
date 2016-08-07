package controllers;

import dto.HallDTO;
import dto.MovieDTO;
import service.impl.HallServiceImpl;
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
@WebServlet(name = "AddSessionServlet", urlPatterns = "/Pages/admin/addSession")
public class AddSessionServlet extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        List<MovieDTO> movieDTOs = MovieServiceImpl.getInstance().getAll();
        List<HallDTO> hallDTOs = HallServiceImpl.getInstance().getAll();
        request.setAttribute("movieDTOs",movieDTOs);
        request.setAttribute("hallDTOs",hallDTOs);
        request.getRequestDispatcher("addSession").forward(request,response);
    }
}
