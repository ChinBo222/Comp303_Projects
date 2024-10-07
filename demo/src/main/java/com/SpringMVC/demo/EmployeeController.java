package com.SpringMVC.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    String message = "Welcome to Spring MVC";

    @RequestMapping("/welcome")
    public ModelAndView printMessage(
            @RequestParam(value = "name", required = false, defaultValue = "Hi") String name) {
        ModelAndView mview = new ModelAndView("empview");
        mview.addObject("empMessage", message);
        mview.addObject("empName", name);
        return mview;
    }
}
