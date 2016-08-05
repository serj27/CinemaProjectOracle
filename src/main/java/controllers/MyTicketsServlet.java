package controllers;

import dto.TicketsDTO;
import dto.UserDTO;
import service.impl.TicketsServiceImpl;

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
@WebServlet(name = "MyTicketsServlet", urlPatterns = "Pages/users/myTickets")
public class MyTicketsServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        List<TicketsDTO> ticketsDTOs = TicketsServiceImpl.getInstance().getByUserID(userDTO.getId().toString());
        request.setAttribute("ticketsDTOs",ticketsDTOs);
        request.getRequestDispatcher("myTickets").forward(request,response);
     }
}
