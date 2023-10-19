package edu.miu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.dto.TransactionDto;
import edu.miu.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
    private TransferService transferService;

    @PostMapping("/checking-to-saving")
    public ResponseEntity<?> fromCheckingToSaving(@RequestBody TransactionDto transactionDto){
        String status = transferService.fromCheckingToSaving(transactionDto);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/saving-to-checking")
    public ResponseEntity<?> fromSavingToChecking(@RequestBody TransactionDto transactionDto){
        String status = transferService.fromSavingToChecking(transactionDto);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
