package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/bloodbanks")
public class BloodBankController {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    // Get all blood banks
    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    // Get a specific blood bank by ID
    @GetMapping("/{id}")
    public BloodBank getBloodBankById(@PathVariable String id) {
        Optional<BloodBank> bloodBank = bloodBankRepository.findById(id);
        return bloodBank.orElse(null);  // Return null if not found
    }

    // Create a new blood bank
    @PostMapping
    public BloodBank createBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    // Update an existing blood bank
    @PutMapping("/{id}")
    public BloodBank updateBloodBank(@PathVariable String id, @RequestBody BloodBank bloodBank) {
        bloodBank.setId(id);
        return bloodBankRepository.save(bloodBank);
    }

    // Delete a blood bank
    @DeleteMapping("/{id}")
    public void deleteBloodBank(@PathVariable String id) {
        bloodBankRepository.deleteById(id);
    }
}