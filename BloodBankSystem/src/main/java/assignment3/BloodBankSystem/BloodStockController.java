package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bloodstocks")
public class BloodStockController {

    private Map<Long, BloodStock> bloodStockMap = new HashMap<>();
    private static long bloodStockIdCounter = 1;

    // Create or update blood stock
    @PostMapping
    public BloodStock saveOrUpdateBloodStock(@RequestBody BloodStock bloodStock) {
        if (bloodStock.getId() == null) {
            bloodStock.setId(bloodStockIdCounter++);
        }
        bloodStockMap.put(bloodStock.getId(), bloodStock);
        return bloodStock;
    }

    // Get all blood stocks
    @GetMapping
    public List<BloodStock> getAllBloodStocks() {
        return new ArrayList<>(bloodStockMap.values());
    }

    // Get a blood stock by ID
    @GetMapping("/{id}")
    public BloodStock getBloodStockById(@PathVariable Long id) {
        return bloodStockMap.get(id);
    }

    // Delete a blood stock
    @DeleteMapping("/{id}")
    public boolean deleteBloodStock(@PathVariable Long id) {
        return bloodStockMap.remove(id) != null;
    }
}
