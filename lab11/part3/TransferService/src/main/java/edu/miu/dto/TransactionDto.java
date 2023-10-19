package edu.miu.dto;

public class TransactionDto {
    private long accountNumber;
    private double amount;
    
    public TransactionDto() {}
	public TransactionDto(long accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransactionDto [accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
    
}
