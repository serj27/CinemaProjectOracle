package filters;

import dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static dto.UserDTO.Role.ADMIN;
import static dto.UserDTO.Role.USER;

/**
 * Created by serj27 on 17.07.2016.
 */
@WebFilter(filterName = "UserFilter", urlPatterns = "/pages/users/*" )
public class UserFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if (userDTO != null && (userDTO.getRole().equals(USER) || userDTO.getRole().equals(ADMIN))) {
            chain.doFilter(req, resp);
        } else {
            request.getSession().setAttribute("url", request.getRequestURI());
            request.getSession().setAttribute("message", "You have to be user");
            response.sendRedirect(request.getContextPath() + "/Pages/common/login.jsp");
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }
}
