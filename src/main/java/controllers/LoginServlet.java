package controllers;

import dto.UserDTO;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDTO userDTO = UserServiceImpl.getInstance().getByLogin(login);

        if (userDTO != null && userDTO.getPassword().equals(password)){
            request.getSession().setAttribute("user",userDTO);
            response.sendRedirect(request.getSession().getAttribute("url").toString());
        } else {
            request.getSession().setAttribute("message", "Wrong user name or password");
            response.sendRedirect(request.getContextPath() + "Pages/common/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        doPost(request,response);
    }
}
