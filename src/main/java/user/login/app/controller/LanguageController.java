package user.login.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController {
    @GetMapping("/language")
    public String changeLanguage() {
        return "change-language";
    }
}
