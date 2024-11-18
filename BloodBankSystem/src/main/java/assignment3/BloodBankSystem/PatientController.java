package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//declare PatientController class as a REST Controller
@RestController
//sets the url path to api/patients for methods inside PatientController class:
@RequestMapping("/api/patients")
public class PatientController {

    //Creates a Map (key) that stores patient Values. (ConcurrentHashMap allows for multiple users)
    private Map<Long, Map<String, Object>> patients = new ConcurrentHashMap<>();
    //Sets the user Id to start at 1
    private long idCounter = 1;

    //Get List of all patients
    @GetMapping
    //returns a list with each item being a map(key + value)
    public List<Map<String, Object>> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    //Get request for specific user Ids
    @GetMapping("/{id}")
    public Map<String, Object> getPatientById(@PathVariable Long id) {
        return patients.get(id);
    }

    //Post request for new users.
    @PostMapping
    public Map<String, Object> createPatient(@RequestBody Map<String, Object> patient) {
        //each new user Id created, increases the counter by 1
        patient.put("id", idCounter++);
        //add new user to the patent map
        patients.put((Long) patient.get("id"), patient);
        return patient;
    }

    //Put request to update user info
    @PutMapping("/{id}")
    public Map<String, Object> updatePatient(@PathVariable Long id, @RequestBody Map<String, Object> patient) {
        patient.put("id", id);
        patients.put(id, patient);
        return patient;
    }

    //Delete request to remove by id
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patients.remove(id);
    }
}