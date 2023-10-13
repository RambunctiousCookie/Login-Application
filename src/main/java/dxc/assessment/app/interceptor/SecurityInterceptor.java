package dxc.assessment.app.interceptor;
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
        LOGGER.info("Intercepting: " + request.getRequestURI());

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            // Redirect to login page if no username, meaning not logged in yet
            response.sendRedirect("/login");
            return false;
        }

        // Have logged-in, forward to Controller
        return true;
    }
}