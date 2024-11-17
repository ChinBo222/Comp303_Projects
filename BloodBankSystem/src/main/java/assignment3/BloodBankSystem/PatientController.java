package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    // In-memory storage for patients
    private Map<Long, Map<String, Object>> patients = new ConcurrentHashMap<>();
    private long idCounter = 1;

    @GetMapping
    public List<Map<String, Object>> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPatientById(@PathVariable Long id) {
        return patients.get(id);
    }

    @PostMapping
    public Map<String, Object> createPatient(@RequestBody Map<String, Object> patient) {
        patient.put("id", idCounter++);
        patients.put((Long) patient.get("id"), patient);
        return patient;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updatePatient(@PathVariable Long id, @RequestBody Map<String, Object> patient) {
        patient.put("id", id);
        patients.put(id, patient);
        return patient;
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patients.remove(id);
    }
}