package com.ChinBoTu_FinalTest_COMP303.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    //Adds a new bank
    @PostMapping
    public ResponseEntity<Bank> addBank(@Valid @RequestBody Bank bank) {
        if (bank.getBankID() == null || bank.getBankID().isEmpty()) {
            bank.setBankID(UUID.randomUUID().toString());
        }
        return ResponseEntity.ok(bankRepository.save(bank));
    }

    //search Bank by name
    @GetMapping("/name/{bankName}")
    public ResponseEntity<Bank> getBankByName(@PathVariable String bankName) {
        Optional<Bank> bank = bankRepository.findByBankName(bankName);
        return bank.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //search bank by id (not being used)
    @GetMapping("/{bankID}")
    public ResponseEntity<Bank> getBankByID(@PathVariable String bankID) {
        Optional<Bank> bank = bankRepository.findByBankID(bankID);
        return bank.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //gets list of all banks in the database
    @GetMapping
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    //deletes bank by name (not used)
    @DeleteMapping("/name/{bankName}")
    public ResponseEntity<String> deleteBankByName(@PathVariable String bankName) {
        bankRepository.deleteByBankName(bankName);
        return ResponseEntity.ok("Bank deleted successfully");
    }

    //deletes bank by id
    @DeleteMapping("/{bankID}")
    public ResponseEntity<String> deleteBankByID(@PathVariable String bankID) {
        bankRepository.deleteByBankID(bankID);
        return ResponseEntity.ok("Bank deleted successfully");
    }

    //updates bank by name (not used)
    @PutMapping("/name/{bankName}")
    public ResponseEntity<Bank> updateBankByName(@PathVariable String bankName, @Valid @RequestBody Bank updatedBank) {
        Optional<Bank> existingBank = bankRepository.findByBankName(bankName);
        if (existingBank.isPresent()) {
            updatedBank.set_id(existingBank.get().get_id());
            updatedBank.setBankID(existingBank.get().getBankID());
            return ResponseEntity.ok(bankRepository.save(updatedBank));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //updates bank by id
    @PutMapping("/{bankID}")
    public ResponseEntity<Bank> updateBank(@PathVariable String bankID, @Valid @RequestBody Bank updatedBank) {
        Optional<Bank> existingBank = bankRepository.findByBankID(bankID);
        if (existingBank.isPresent()) {
            updatedBank.set_id(existingBank.get().get_id()); // Preserve MongoDB _id
            updatedBank.setBankID(bankID); // Ensure bankID matches
            return ResponseEntity.ok(bankRepository.save(updatedBank));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
