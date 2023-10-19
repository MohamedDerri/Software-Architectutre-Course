package edu.miu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.dto.CheckingAccountDto;
import edu.miu.dto.TransactionDto;
import edu.miu.service.CheckingAccountService;

@RestController
@RequestMapping("/checking-account")
public class CheckingAccountController {
	
	@Autowired
    private CheckingAccountService checkingAccountService;

    @PostMapping("/create")
    public ResponseEntity<?> createCheckingAccount(@RequestBody CheckingAccountDto checkingAccountDto) {
            return new ResponseEntity<>(checkingAccountService.createCheckingAccount(checkingAccountDto), HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionDto transactionDto) throws Exception {
            checkingAccountService.deposit(transactionDto);
            return new ResponseEntity<>("Amount deposit successful.", HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody TransactionDto transactionDto) throws Exception {
            return new ResponseEntity<>(checkingAccountService.withdraw(transactionDto), HttpStatus.OK);
    }
}
