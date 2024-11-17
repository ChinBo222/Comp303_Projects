package assignment3.BloodBankSystem;

// Import dependencies:
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/bloodstocks")
public class BloodStockController {

    // In-memory storage for blood stocks
    private Map<Long, Map<String, Object>> bloodStocks = new ConcurrentHashMap<>();
    private long idCounter = 1;

    @GetMapping
    public List<Map<String, Object>> getAllBloodStocks() {
        return new ArrayList<>(bloodStocks.values());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBloodStockById(@PathVariable Long id) {
        return bloodStocks.get(id);
    }

    @PostMapping
    public Map<String, Object> createBloodStock(@RequestBody Map<String, Object> bloodStock) {
        bloodStock.put("id", idCounter++);
        bloodStocks.put((Long) bloodStock.get("id"), bloodStock);
        return bloodStock;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateBloodStock(@PathVariable Long id, @RequestBody Map<String, Object> bloodStock) {
        bloodStock.put("id", id);
        bloodStocks.put(id, bloodStock);
        return bloodStock;
    }

    @DeleteMapping("/{id}")
    public void deleteBloodStock(@PathVariable Long id) {
        bloodStocks.remove(id);
    }
}