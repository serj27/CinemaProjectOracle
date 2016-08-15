package controllers;

import dto.SessionDTO;
import service.impl.SessionServiceImpl;

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
@WebServlet(name = "ChangeSessionServlet", urlPatterns = "/Pages/admin/changeSessions")
public class ChangeSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SessionDTO> sessionDTOs = SessionServiceImpl.getInstance().getByMovieID(request.getParameter("id"));
        request.setAttribute("sessionDTOs",sessionDTOs);
        request.getRequestDispatcher("changeSessions.jsp").forward(request,response);
    }
}
