package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.CustomerService;

@Controller
public class CustomerController{

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/customer") //ชื่อ URL
    public String getCustomerPage(Model model) {

        model.addAttribute("allCustomers", customerService.getCustomers());
        return "Customer"; //ชื่อไฟล์ Customer.html

    }

    @PostMapping("/customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model){

        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";

    }


}



