package dxc.assessment.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class CommonController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(String username, Model model, HttpSession session) {
        if (username.equalsIgnoreCase("dipsa")) {
            session.setAttribute("username", username);

            return "redirect:/manager/department";
        }

        return "login";
    }


}
