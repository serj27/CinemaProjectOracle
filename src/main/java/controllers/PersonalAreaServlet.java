package controllers;

import dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by serjd on 04.08.2016.
 */
@WebServlet(name = "PersonalAreaServlet", urlPatterns = "/Pages/users/personalPage")
public class PersonalAreaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        request.setAttribute("userDTO", userDTO);
        if (userDTO.getRole() == UserDTO.Role.USER){
            request.getRequestDispatcher("personalPage").forward(request,response);
        }else if (userDTO.getRole() == UserDTO.Role.ADMIN){
            response.sendRedirect("/webapp/Pages/admin/admin");
        }
    }


}
