package com.example.student_enrollment_process;


import com.example.student_enrollment_process.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ProgramRepository extends JpaRepository<Program, String> {
    double findAmountByProgramCode(String programCode);
    // Checks for existing studentid
    boolean existsById(String programCode);
 
}