package controllers;

import dto.SessionDTO;
import service.impl.SessionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "UpdateSessionsServlet", urlPatterns = "/Pages/admin/updateSessions")
public class UpdateSessionsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionDTO sessionDTO = SessionServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("sessionDTO",sessionDTO);
        request.getRequestDispatcher("updateSessions.jsp").forward(request,response);
    }
}
