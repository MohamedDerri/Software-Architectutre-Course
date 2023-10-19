package edu.miu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.dto.CheckingAccountDto;
import edu.miu.dto.TransactionDto;
import edu.miu.model.CheckingAccount;
import edu.miu.repository.CheckingAccountRepository;

@Service
public class CheckingAccountService {
	
	@Autowired
    private CheckingAccountRepository checkingAccountRepository;
	@Autowired
	private ModelMapper modelMapper;

    public String createCheckingAccount(CheckingAccountDto checkingAccountDto) {
        if (checkingAccountRepository.findById(checkingAccountDto.getAccountNumber()).isPresent()) {
            return "Account already exist."; 
        }
        CheckingAccount checkingAccount = modelMapper.map(checkingAccountDto, CheckingAccount.class);
        checkingAccountRepository.save(checkingAccount);
        
        String responseMessage = "Account successfully created.";
        return responseMessage;
    }

    public boolean deposit(TransactionDto transactionDto) throws Exception {
        CheckingAccount account = checkingAccountRepository.findById(transactionDto.getAccountNumber()).orElseThrow(Exception::new);
        double addedAmount = account.getAmount() + transactionDto.getAmount();
        account.setAmount(addedAmount);
        checkingAccountRepository.save(account);
        return true;
    }

    public String withdraw(TransactionDto transactionDto) throws Exception {
        CheckingAccount account = checkingAccountRepository.findById(transactionDto.getAccountNumber()).orElseThrow(Exception::new);
        if(account.getAmount() < transactionDto.getAmount())
            throw new Exception("Transaction failed.");
        double addedAmount = account.getAmount() - transactionDto.getAmount();
        account.setAmount(addedAmount);
        checkingAccountRepository.save(account);

        String responseMessage = "Withdraw was successful.";
        return responseMessage;
    }
}
