package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    LaptopRepository laptopRepository;

    @RequestMapping("/")
    public String index(Model model){
        Employee emp1 = new Employee();
        emp1.setName("John Doe");
        emp1.setAddress("123 Some Street Anytown, USA");

        Laptop laptop1 = new Laptop();
        laptop1.setBrand("Apple");
        laptop1.setModel("MacBook Pro");

        emp1.setLaptop(laptop1);
        laptop1.setEmployee(emp1);

        employeeRepository.save(emp1);
        laptopRepository.save(laptop1);

        model.addAttribute("employees", employeeRepository.findAll());


        return "index";
    }
}
