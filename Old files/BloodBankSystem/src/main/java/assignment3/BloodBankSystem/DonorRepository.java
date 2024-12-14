package assignment3.BloodBankSystem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends MongoRepository<Donor, String> {
    Optional<Donor> findByEmail(String email);

}
