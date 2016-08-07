package controllers;

import dto.SessionDTO;
import dto.TicketsDTO;
import dto.UserDTO;
import service.impl.SessionServiceImpl;
import service.impl.TicketsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "ThxForBuyTicketsServlet",urlPatterns = "/thxForBuyTickets")
public class ThxForBuyTicketsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionDTO sessionDTO = SessionServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("session_id")));
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        String rowSeat[] = request.getParameterValues("row-seat");
        Pattern pattern = Pattern.compile("(\\d+)[:](\\d+)");
        for (String s:rowSeat) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                TicketsServiceImpl.getInstance().save(new TicketsDTO(userDTO.getId(),sessionDTO.getId(),Integer.parseInt(matcher.group(1)),
                        Integer.parseInt(matcher.group(2)), false));
            }
        }
        request.getRequestDispatcher("/Pages/common/homePage").forward(request,response);
    }
}
