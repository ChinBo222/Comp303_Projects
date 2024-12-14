package assignment3.BloodBankSystem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BloodBankRepository extends MongoRepository<BloodBank, String> {
    // Additional query methods can be defined here if needed
}
