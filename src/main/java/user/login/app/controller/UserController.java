package user.login.app.controller;

import user.login.app.model.Employee;
import user.login.app.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final EmployeeService employeeService;

    @Autowired
    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        Employee currentEmployee = employeeService.findValidEmployeeByUsername(username);
        String role = (String) session.getAttribute("role");
        //role = role.substring(0, 1).toUpperCase() + role.substring(1);  //revert or use stringbuilder- minor performance impact
        model.addAttribute("currentEmployee", currentEmployee);
        model.addAttribute("role", role);
        return "welcome-page";
    }

    @GetMapping("/secret")
    public String secret(Model model, HttpSession session) {
        return "secret-page";
    }

    @GetMapping("/department")
    public String dashboard(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        Employee currentEmployee = employeeService.findValidEmployeeByUsername(username);
        List<Employee> teamMembers = employeeService.findValidEmployeesByDeptId(currentEmployee.getDepartment().getId());
        teamMembers.remove(currentEmployee);

        model.addAttribute("teamMembers", teamMembers);
        return "department-info";
    }

}
