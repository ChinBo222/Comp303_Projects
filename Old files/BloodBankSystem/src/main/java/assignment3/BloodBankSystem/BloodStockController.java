package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/bloodstocks")
public class BloodStockController {
    @Autowired
    private BloodStockRepository bloodStockRepository;

    // Get all blood stocks
    @GetMapping
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockRepository.findAll();
    }

    // Get a specific blood stock by ID
    @GetMapping("/{id}")
    public BloodStock getBloodStockById(@PathVariable String id) {
        Optional<BloodStock> bloodStock = bloodStockRepository.findById(id);
        return bloodStock.orElse(null);  // Return null if not found
    }

    // Create a new blood stock
    @PostMapping
    public BloodStock createBloodStock(@RequestBody BloodStock bloodStock) {
        return bloodStockRepository.save(bloodStock);
    }

    // Update an existing blood stock
    @PutMapping("/{id}")
    public BloodStock updateBloodStock(@PathVariable String id, @RequestBody BloodStock bloodStock) {
        bloodStock.setId(id);
        return bloodStockRepository.save(bloodStock);
    }

    // Delete a blood stock
    @DeleteMapping("/{id}")
    public void deleteBloodStock(@PathVariable String id) {
        bloodStockRepository.deleteById(id);
    }

    // Check blood availability
    @GetMapping("/availability/{bloodGroup}")
    public ResponseEntity<Map<String, Object>> checkBloodAvailability(@PathVariable String bloodGroup) {
        List<BloodStock> bloodStocks = bloodStockRepository.findByBloodGroup(bloodGroup);
        Map<String, Object> response = new HashMap<>();

        if (bloodStocks.isEmpty()) {
            response.put("message", "Blood group " + bloodGroup + " is not available.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        int totalQuantity = bloodStocks.stream().mapToInt(BloodStock::getQuantity).sum();
        response.put("bloodGroup", bloodGroup);
        response.put("quantity", totalQuantity);
        response.put("status", "Available");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}