package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private Map<Long, Patient> patientMap = new HashMap<>(); // Corrected initialization
    private static long patientIdCounter = 1; // Corrected variable name

    // Create or update a patient
    @PostMapping
    public Patient saveOrUpdatePatient(@RequestBody Patient patient) { // Corrected annotation
        if (patient.getId() == null) { // Fixed syntax error
            patient.setId(patientIdCounter++);
        }
        patientMap.put(patient.getId(), patient);
        return patient;
    }

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientMap.values());
    }

    // Get patient by id
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) { // Corrected method name
        return patientMap.get(id);
    }

    // Delete a patient
    @DeleteMapping("/{id}")
    public boolean deletePatient(@PathVariable Long id) { // Corrected annotation
        return patientMap.remove(id) != null;
    }
}
