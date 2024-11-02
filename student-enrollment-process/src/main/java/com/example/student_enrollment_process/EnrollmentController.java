package com.example.student_enrollment_process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private StudentRepository studentRepository;

    //logic for enrolling in a course
    @PostMapping("/enroll")
    public String enrollStudent(
            @RequestParam String programCode,
            @RequestParam String username,
            Model model) {

        // Retrieve studentId based on the provided username
        Integer studentId = getStudentIdFromUsername(username);

        // Check if studentId is valid and program code exists
        if (studentId != null && programRepository.existsById(programCode)) {
            Enrollment enrollment = new Enrollment();
            // Set the student ID directly
            enrollment.setStudentId(studentId);
            // Set the program code directly
            enrollment.setProgramCode(programCode);

            // Retrieve the program  to get the fee
            Program program = programRepository.findById(programCode).orElse(null);
            if (program != null) {
                //if the program does exist, then set amountpaid to the fee from the database
                double amountPaid = program.getFee();
                enrollment.setAmountPaid(amountPaid);
                //set the start date of the program for today
                enrollment.setStartDate(LocalDate.now().toString());

                // Save the enrollment
                enrollmentRepository.save(enrollment);
                model.addAttribute("enrollmentSuccess", "Enrollment successful! Application number: " + enrollment.getApplicationNo());
            }
        } else {
            model.addAttribute("enrollmentError", "Invalid program code or student not found.");
        }

        // Redirect back to homepage page after enrollment
        return "welcome";
    }

    private Integer getStudentIdFromUsername(String username) {
        Student student = studentRepository.findByUserName(username);
        if (student != null) {
            return student.getStudentId();
        }
        return null;
    }
}
