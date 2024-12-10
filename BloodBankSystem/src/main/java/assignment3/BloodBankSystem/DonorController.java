package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//declare PatientController class as a REST Controller
@RestController
//sets the url path to api/patients for methods inside PatientController class:
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorRepository donorRepository;

    // Get all patients
    @GetMapping
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    // Get a specific patient by ID
    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable String id) {
        Optional<Donor> donor = donorRepository.findById(id);
        return donor.orElse(null);  // Return null if not found
    }

    // Create a new patient
    @PostMapping
    public Donor createDonor(@RequestBody Donor donor) {
        return donorRepository.save(donor);
    }

    // Update an existing patient
    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable String id, @RequestBody Donor donor) {
        donor.setId(id);
        return donorRepository.save(donor);
    }

    // Delete a patient
    @DeleteMapping("/{id}")
    public void deleteDonor(@PathVariable String id) {
        donorRepository.deleteById(id);
    }

    @GetMapping("/{id}/history")
    public List<BloodStock> getDonorHistory(@PathVariable String id) {
        Optional<Donor> donor = donorRepository.findById(id);
        return donor.map(Donor::getDonations).orElse(null);
    }


    //log in:
    @PostMapping("/login")
    public ResponseEntity<?> loginDonor(@RequestBody Donor loginRequest) {
        Optional<Donor> donor = donorRepository.findByEmail(loginRequest.getEmail());
        if (donor.isPresent() && donor.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(donor.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}