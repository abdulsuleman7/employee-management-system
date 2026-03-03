//
//package com.codec.employeemanagement.controller;
//
//import com.codec.employeemanagement.model.Employee;
//import com.codec.employeemanagement.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService service;
//
//    // Add Employee
//    @PostMapping("/add")
//    public Employee addEmployee(@ModelAttribute Employee employee) {
//        service.saveEmployee(employee);
//        return  "redirect:/employee";
//
//    }
//
//    // Get All Employees
//    @GetMapping("/all")
//    public List<Employee> getAllEmployees() {
//        return service.getAllEmployees();
//    }
//
//    // Get Employee By ID
//    @GetMapping("/{id}")
//    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
//        return service.getEmployeeById(id);
//    }
//
//    // Delete Employee
//    @DeleteMapping("/delete/{id}")
//    public String deleteEmployee(@PathVariable Long id) {
//        service.deleteEmployee(id);
//        return "Employee deleted successfully!";
//    }
//}



package com.codec.employeemanagement.controller;

import com.codec.employeemanagement.model.Employee;
import com.codec.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Show Employee Page (List + Form)
    @GetMapping
    public String viewEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        model.addAttribute("employee", new Employee());
        return "employees";
    }

    // Save Employee
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees";
    }

    // Delete Employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
}
