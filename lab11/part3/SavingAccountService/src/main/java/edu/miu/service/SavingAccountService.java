package edu.miu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.dto.SavingAccountDto;
import edu.miu.dto.TransactionDto;
import edu.miu.model.SavingAccount;
import edu.miu.repository.SavingAccountRepository;

@Service
public class SavingAccountService {

	@Autowired
	private SavingAccountRepository savingAccountRepository;
	@Autowired
	private ModelMapper modelMapper;

	public String createSavingAccount(SavingAccountDto checkingAccountDto) {
		String responseMessage = "";

		if (savingAccountRepository.findById(checkingAccountDto.getAccountNumber()).isPresent()) {
			responseMessage = "Account already exist.";
		} else {
			SavingAccount savingAccount = modelMapper.map(checkingAccountDto, SavingAccount.class);
			savingAccountRepository.save(savingAccount);
			responseMessage = "Account created successfully.";
		}

		return responseMessage;
	}

	public String deposit(TransactionDto transactionDto) throws Exception {
		SavingAccount account = savingAccountRepository.findById(transactionDto.getAccountNumber())
				.orElseThrow(Exception::new);
		double addedAmount = account.getAmount() + transactionDto.getAmount();
		account.setAmount(addedAmount);
		savingAccountRepository.save(account);

		String responseMessage = "Deposit is successful.";
		return responseMessage;
	}

	public String withdraw(TransactionDto transactionDto) throws Exception {
		String responseMessage = "";

		SavingAccount account = savingAccountRepository.findById(transactionDto.getAccountNumber())
				.orElseThrow(Exception::new);
		if (account.getAmount() < transactionDto.getAmount())
			responseMessage = "Transaction failed.";
		else {
			double addedAmount = account.getAmount() - transactionDto.getAmount();
			account.setAmount(addedAmount);
			savingAccountRepository.save(account);
			responseMessage = "Transaction is successful.";
		}
		return responseMessage;
	}
}
