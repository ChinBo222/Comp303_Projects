package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/bloodbanks")
public class BloodBankController {

    // In-memory storage for blood banks
    private Map<Long, Map<String, Object>> bloodBanks = new ConcurrentHashMap<>();
    private long idCounter = 1;

    @GetMapping
    public List<Map<String, Object>> getAllBloodBanks() {
        return new ArrayList<>(bloodBanks.values());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBloodBankById(@PathVariable Long id) {
        return bloodBanks.get(id);
    }

    @PostMapping
    public Map<String, Object> createBloodBank(@RequestBody Map<String, Object> bloodBank) {
        bloodBank.put("id", idCounter++);
        bloodBanks.put((Long) bloodBank.get("id"), bloodBank);
        return bloodBank;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateBloodBank(@PathVariable Long id, @RequestBody Map<String, Object> bloodBank) {
        bloodBank.put("id", id);
        bloodBanks.put(id, bloodBank);
        return bloodBank;
    }

    @DeleteMapping("/{id}")
    public void deleteBloodBank(@PathVariable Long id) {
        bloodBanks.remove(id);
    }
}