package controllers;

import dto.RowDTO;
import dto.SessionDTO;
import service.impl.RowServiceImpl;
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
@WebServlet(name = "SessionServlet", urlPatterns = "/Pages/users/session")
public class SessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        SessionDTO sessionDTO = SessionServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("session_id")));
        List<RowDTO> rowDTOs = RowServiceImpl.getInstance().getByHallID(request.getParameter("hall_id"));
        request.setAttribute("rowDTOs",rowDTOs);
        request.setAttribute("sessionDTO",sessionDTO);
        request.getRequestDispatcher("session").forward(request,response);
    }

}
