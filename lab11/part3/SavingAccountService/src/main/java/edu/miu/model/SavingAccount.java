package edu.miu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SavingAccount {
    @Id
    private long accountNumber;
    private String name;
    private String phone;
    private double amount;
    
    public SavingAccount() {}
	public SavingAccount(long accountNumber, String name, String phone, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.phone = phone;
		this.amount = amount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SavingAccount [accountNumber=" + accountNumber + ", name=" + name + ", phone=" + phone + ", amount="
				+ amount + "]";
	}
}
