package com.Assignment_1.DigiTel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Declares this file as the controller
@Controller
public class OrderController {

    //Maps the request to the index homepage
    @RequestMapping("/")
    public String showOrderForm() {
        return "index";
    }

    //recieves the post from the index form, then  passes the information to the processOrder method
    @PostMapping("/order")
    public String processOrder(@ModelAttribute Order order, Model model) {
        //data is passed into the order.java class
        model.addAttribute("order", order);
        //then return the show-order html
        return "show-order";
    }
}
