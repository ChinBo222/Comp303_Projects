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

    //Creates map for bloodstocks
    private Map<Long, Map<String, Object>> bloodStocks = new ConcurrentHashMap<>();
    private long idCounter = 1;

    //get request for list of all bloodstocks
    @GetMapping
    public List<Map<String, Object>> getAllBloodStocks() {
        return new ArrayList<>(bloodStocks.values());
    }

    //get request for specific bloodstock by id
    @GetMapping("/{id}")
    public Map<String, Object> getBloodStockById(@PathVariable Long id) {
        return bloodStocks.get(id);
    }

    //post request to add new bloodstock information
    @PostMapping
    public Map<String, Object> createBloodStock(@RequestBody Map<String, Object> bloodStock) {
        bloodStock.put("id", idCounter++);
        bloodStocks.put((Long) bloodStock.get("id"), bloodStock);
        return bloodStock;
    }

    //put request to update bloodstock info
    @PutMapping("/{id}")
    public Map<String, Object> updateBloodStock(@PathVariable Long id, @RequestBody Map<String, Object> bloodStock) {
        bloodStock.put("id", id);
        bloodStocks.put(id, bloodStock);
        return bloodStock;
    }

    //delete a bloodstock
    @DeleteMapping("/{id}")
    public void deleteBloodStock(@PathVariable Long id) {
        bloodStocks.remove(id);
    }
}