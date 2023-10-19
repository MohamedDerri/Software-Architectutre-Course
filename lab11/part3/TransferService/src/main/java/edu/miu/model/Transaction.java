package edu.miu.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.miu.dto.TransactionDto;

@Document
public class Transaction {
	@Id
	private String id;
	private long accountNumber;
	private String fromAccountType;
	private String toAccountType;
	private double amount;
	private String status;

	public Transaction() {
	}

	public Transaction(TransactionDto transactionDto) {
		this.id = UUID.randomUUID().toString();
		this.accountNumber = transactionDto.getAccountNumber();
		this.amount = transactionDto.getAmount();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFromAccountType() {
		return fromAccountType;
	}

	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public String getToAccountType() {
		return toAccountType;
	}

	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", accountNumber=" + accountNumber + ", fromAccountType=" + fromAccountType
				+ ", toAccountType=" + toAccountType + ", amount=" + amount + ", status=" + status + "]";
	}

}
