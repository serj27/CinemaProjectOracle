package controllers;

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
@WebServlet(name = "DeleteSessionServlet", urlPatterns = "Pages/admin/deleteSession")
public class DeleteSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        SessionServiceImpl.getInstance().delete(Integer.parseInt(request.getParameter("id")));
        request.getRequestDispatcher("changeSessions").forward(request,response);
    }
}
