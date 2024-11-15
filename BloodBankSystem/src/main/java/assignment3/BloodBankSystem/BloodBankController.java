package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bloodbanks")
public class BloodBankController {

    private Map<Long, BloodBank> bloodBankMap = new HashMap<>();
    private static long bloodBankIdCounter = 1;

    // Create or update a blood bank
    @PostMapping
    public BloodBank updateBloodBank(@RequestBody BloodBank bloodBank) { // Corrected method name
        if (bloodBank.getId() == null) {
            bloodBank.setId(bloodBankIdCounter++);
        }
        bloodBankMap.put(bloodBank.getId(), bloodBank);
        return bloodBank;
    }

    // Get all blood banks
    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return new ArrayList<>(bloodBankMap.values());
    }

    // Search by id
    @GetMapping("/{id}")
    public BloodBank getBloodBankById(@PathVariable Long id) {
        return bloodBankMap.get(id);
    }

    // Delete blood bank
    @DeleteMapping("/{id}")
    public boolean deleteBloodBank(@PathVariable Long id) {
        return bloodBankMap.remove(id) != null;
    }
}
