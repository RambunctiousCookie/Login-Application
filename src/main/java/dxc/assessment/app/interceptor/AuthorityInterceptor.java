package dxc.assessment.app.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SecurityInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws IOException {
        LOGGER.info("Intercepting- check if user is a manager: " + request.getRequestURI());

        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (role != "manager") {
            response.sendRedirect("/error/unauthorized");
            return false;
        }
        return true;
    }
}
