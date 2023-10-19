package edu.miu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.dto.SavingAccountDto;
import edu.miu.dto.TransactionDto;
import edu.miu.service.SavingAccountService;

@RestController
@RequestMapping("/saving-account")
public class SavingAccountController {
	
	@Autowired
    private SavingAccountService savingAccountService;

    @PostMapping("/create")
    public ResponseEntity<?> createCheckingAccount(@RequestBody SavingAccountDto savingAccountDto) {
            return new ResponseEntity<>(savingAccountService.createSavingAccount(savingAccountDto), HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionDto transactionDto) throws Exception {
            return new ResponseEntity<>(savingAccountService.deposit(transactionDto), HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody TransactionDto transactionDto) throws Exception {
            return new ResponseEntity<>(savingAccountService.withdraw(transactionDto), HttpStatus.OK);
    }
}
