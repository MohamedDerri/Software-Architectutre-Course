package edu.miu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.miu.dto.TransactionDto;
import edu.miu.feign.AccountFeignClient;
import edu.miu.feign.CheckingAccountFeignClient;
import edu.miu.feign.SavingAccountFeignClient;
import edu.miu.model.Transaction;
import feign.FeignException;
import lab11.part3.transferservice.repository.TransferRepository;

@Service
public class TransferService {
	
	@Autowired
    private TransferRepository transferRepository;
	@Autowired
	private CheckingAccountFeignClient checkingAccountFeignClient;
	@Autowired
	private SavingAccountFeignClient savingAccountFeignClient;

    public String fromCheckingToSaving(TransactionDto transactionDto) {
        Transaction transaction = new Transaction(transactionDto);
        transaction.setFromAccountType("checking");
        transaction.setToAccountType("saving");
        updateTransactionStatus(transaction, "pending");

        ResponseEntity<String> response = sendWithdrawRequest(checkingAccountFeignClient, transactionDto);
        if(response.getStatusCode() != HttpStatus.OK) {
            updateTransactionStatus(transaction, "withdraw failed");
            return "transfer failed";
        }
        response = sendDepositRequest(savingAccountFeignClient, transactionDto);
        if(response.getStatusCode() != HttpStatus.OK) {
            updateTransactionStatus(transaction, "deposit failed");
            sendDepositRequest(checkingAccountFeignClient, transactionDto);
            return "transfer failed";
        }
        updateTransactionStatus(transaction, "completed");
        return "transfer completed";
    }

    public String fromSavingToChecking(TransactionDto transactionDto) {
        Transaction transaction = new Transaction(transactionDto);
        transaction.setFromAccountType("saving");
        transaction.setToAccountType("checking");
        updateTransactionStatus(transaction, "pending");

        ResponseEntity<String> response = sendWithdrawRequest(savingAccountFeignClient, transactionDto);
        if(response.getStatusCode() != HttpStatus.OK) {
            updateTransactionStatus(transaction, "withdraw failed");
            return "transfer failed";
        }
        response = sendDepositRequest(checkingAccountFeignClient, transactionDto);
        if(response.getStatusCode() != HttpStatus.OK) {
            updateTransactionStatus(transaction, "deposit failed");
            sendDepositRequest(savingAccountFeignClient, transactionDto);
            return "transfer failed";
        }
        updateTransactionStatus(transaction, "completed");;
        return "transfer completed";
    }

    private void updateTransactionStatus(Transaction transaction, String status){
        transaction.setStatus(status);
        transferRepository.save(transaction);
    }

    private ResponseEntity<String> sendWithdrawRequest(AccountFeignClient accountFeignClient, TransactionDto transactionDto){
        try{
            return accountFeignClient.withdraw(transactionDto);
        } catch (FeignException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

    private ResponseEntity<String> sendDepositRequest(AccountFeignClient accountFeignClient, TransactionDto transactionDto){
        try{
            return accountFeignClient.deposit(transactionDto);
        } catch (FeignException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
