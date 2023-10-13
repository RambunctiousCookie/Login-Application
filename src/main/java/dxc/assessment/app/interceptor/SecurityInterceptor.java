package dxc.assessment.app.interceptor;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws IOException {
        String uri = request.getRequestURI();
        LOGGER.info("Intercepting- " + uri);
        if (uri.startsWith("/css/")) { //accidentally intercepting css
            return true;
        }

        if (uri.equalsIgnoreCase("/") || uri.equalsIgnoreCase("/home")
                || uri.equalsIgnoreCase("/login")
                || uri.equalsIgnoreCase("/language")) {
            return true;
        }
        if (uri.startsWith("/home/")) {
            return true;
        }

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) { // conditional for login criteria
            response.sendRedirect("/login");
            return false;
        }

        String role = (String) session.getAttribute("role");
        Employee roleObject = switch (role) {
            case "manager" -> new Manager();
            case "employee" -> new Employee();
            default -> throw new IllegalArgumentException("Role is invalid!");
        };

        if(uri.startsWith("/employee") && !(roleObject instanceof Employee)){
            response.sendRedirect("/error/unauthorized");
            return false;
        }

        if(uri.startsWith("/manager") && !(roleObject instanceof Manager)){
            response.sendRedirect("/error/unauthorized");
            return false;
        }

        return true;    //forward to Controller
    }
}