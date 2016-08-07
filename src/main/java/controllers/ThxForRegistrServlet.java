package controllers;

import dto.UserDTO;
import service.impl.UserServiceImpl;

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
@WebServlet(name = "ThxForRegistrServlet",urlPatterns = "/thxForRegistr")
public class ThxForRegistrServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String email = request.getParameter("email");
        UserDTO.Gender gender = UserDTO.Gender.valueOf(request.getParameter("gender"));
        LocalDate birthday = LocalDate.of(Integer.parseInt(request.getParameter("year")),
                Integer.parseInt(request.getParameter("month")), Integer.parseInt(request.getParameter("day")));
        UserServiceImpl.getInstance().save(new UserDTO(login,password,firstName,secondName,email,gender,birthday, UserDTO.Role.USER));
        request.getRequestDispatcher("/Pages/common/homePage").forward(request,response);
    }
}
