package dxc.assessment.app.controller;
import dxc.assessment.app.model.Employee;
import dxc.assessment.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private EmployeeService employeeService;

    @Autowired
    public ManagerController(EmployeeService employeeService) {
        this.employeeService = employeeService;
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

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome-page";
    }
}
