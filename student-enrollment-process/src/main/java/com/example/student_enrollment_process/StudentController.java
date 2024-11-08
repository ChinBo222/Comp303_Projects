package com.example.student_enrollment_process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
//This controller is to contain the logic and mapping of the Students, which then stores the data in the StudentRepository

@Controller
public class StudentController {

    // Links to the student repository to store student-related data
    @Autowired
    private StudentRepository studentRepository;


    //Registration logic:

    // Display index as the registration page (mostly a landing page)
    @GetMapping("/")
    //Model parameter called displayFields passes the data from this controller to the index
    public String showForm(Model displayFields) {
        // Creates empty student form to fill
        displayFields.addAttribute("student", new Student());
        // Return the default view
        return "index";
    }
    //post request: when user inputs student information in registration field
    @PostMapping("/")
    //creates a method called regiesterStudent;
    //@ModelAttribute matches the properties in the student class to set as newStudentData
    public String registerStudent(@ModelAttribute("student") Student newStudentData, Model displayUpdatedField) {
        try {
            //if student data is saved properly ; display success message
            studentRepository.save(newStudentData);
            displayUpdatedField.addAttribute("successMsg", "Registration successful! Please log in below.");
        }
        catch (Exception e) {
            //if it doesn't save, throw this error message
            displayUpdatedField.addAttribute("errorMsg", "Registration failed: " + e.getMessage());
        }
        //reloads the page with the related error message
        return "index";
    }



    //Login logic:

    @PostMapping("/login")
    public String loginStudent(String userName, String password, Model model) {
        Student student = studentRepository.findByUserName(userName);
        if (student == null || !student.getPassword().equals(password)) {
            // Add an empty 'student' object, so that when the page reloads, it still has the student package:
            //explaination: the student item was added in the initial show form.
            //the post method to register a new student automatically grabs that object to update information.
            //However, when you go to log in, and in the case where u input the wrong info, that student object might not exist anymore
            //so I need to add it here again
            model.addAttribute("student", new Student());
            model.addAttribute("loginErrorMessage", "Invalid username or password. Please try again.");
            return "index"; // Reloads index with an error message on login failure
        }

        // Successful login, print message to welcome.html
        model.addAttribute("welcomeMessage", "Welcome, " + student.getFirstName() + "!");
        return "welcome"; // Redirects to the welcome page if login is successful
    }


    //edit personal information logic:
    @GetMapping("/editStudent")
    public String editStudentForm(Model model) {
        // Placeholder for now
        model.addAttribute("student", new Student());
        //directs user to the editStudent.html
        return "editStudent";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestParam("userName") String userName,
                                @RequestParam("password") String password,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("address") String address,
                                @RequestParam("city") String city,
                                @RequestParam("postalCode") String postalCode,
                                Model model) {

        // finds the user using their username
        Student student = studentRepository.findByUserName(userName);
        //security feature to check inputed password. I dont knw how to actually make a proper set up.
        if (student == null || !student.getPassword().equals(password)) {
            // if either username or password are wrong, throw this error mesage
            model.addAttribute("errorMsg", "Invalid username or password. Please try again.");
            return "editStudent";
        }

        // Update the existing student's information (but not the studentID)
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAddress(address);
        student.setCity(city);
        student.setPostalCode(postalCode);

        // Save the updated information without changing the ID
        studentRepository.save(student);

        // Add success message
        model.addAttribute("successMsg", "Your information has been updated successfully.");
        return "welcome";
    }




}



