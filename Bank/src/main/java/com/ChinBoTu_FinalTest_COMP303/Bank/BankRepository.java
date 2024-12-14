package com.ChinBoTu_FinalTest_COMP303.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankRepository extends MongoRepository<Bank, String> {

    //some methods for crud operations
    Optional<Bank> findByBankName(String bankName);
    Optional<Bank> findByBankID(String bankID); // Custom finder method
    void deleteByBankName(String bankName);
    void deleteByBankID(String bankID); // Custom delete method
}