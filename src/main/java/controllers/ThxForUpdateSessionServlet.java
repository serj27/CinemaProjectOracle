package controllers;

import dto.SessionDTO;
import service.impl.SessionServiceImpl;

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
@WebServlet(name = "ThxForUpdateSessionServlet",urlPatterns = "/thxForUpdateSession")
public class ThxForUpdateSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        LocalDate startSession = LocalDate.of(Integer.parseInt(request.getParameter("syear")),
                Integer.parseInt(request.getParameter("smonth")), Integer.parseInt(request.getParameter("sday")));
        double price = Double.parseDouble(request.getParameter("price"));

        SessionDTO sessionDTO = SessionServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        sessionDTO.setPrice(price);
        sessionDTO.setStartSession(startSession);
        SessionServiceImpl.getInstance().update(sessionDTO);

        request.getRequestDispatcher("Pages/admin/admin").forward(request,response);
    }

}
