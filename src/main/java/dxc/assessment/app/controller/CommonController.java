package dxc.assessment.app.controller;

import dxc.assessment.app.model.Employee;
import dxc.assessment.app.model.Manager;
import dxc.assessment.app.service.EmployeeService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    private EmployeeService employeeService;

    @Autowired
    public CommonController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"/", "/login", "/home"})
    public String login(Model model) {
        model.addAttribute("user", new Employee());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(String username, String password, Model model, HttpSession session) {
        boolean loginSuccess = employeeService.authenticateLogin(username, password);
        Employee currentEmployee = employeeService.findValidEmployeeByUsername(username);

        if (!loginSuccess) {
            model.addAttribute("loginMessage", "Invalid userid or password");
            return "login";
//            model.addAttribute("errorMessage", "Username invalid. Please try again.");
//            return "error-page-modular";
        }
        else{
            session.setAttribute("username", username);
            if (currentEmployee instanceof Manager)
                session.setAttribute("role", "manager");
            else
                session.setAttribute("role", "user");
            return "redirect:/user/welcome";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}
