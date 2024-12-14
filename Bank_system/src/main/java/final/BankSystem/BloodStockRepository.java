package assignment3.BloodBankSystem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodStockRepository extends MongoRepository<BloodStock, String> {
    // Additional custom query methods can be added here if needed
    List<BloodStock> findByBloodGroup(String bloodGroup);
}
