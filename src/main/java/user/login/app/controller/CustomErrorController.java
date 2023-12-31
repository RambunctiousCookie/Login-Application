package user.login.app.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.error.ErrorController;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        model.addAttribute("errorMessage", "Sorry, something went wrong.");
        return "error-page-modular";
    }

    @RequestMapping("/error/unauthorized")
    public String handleErrorUnauthorized(Model model, HttpServletRequest request) {
        model.addAttribute("errorMessage", "You are not allowed to enter this page.");
        return "error-page-modular";
    }
}
