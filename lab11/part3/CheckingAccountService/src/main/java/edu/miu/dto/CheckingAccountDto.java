package edu.miu.dto;

public class CheckingAccountDto {
    private long accountNumber;
    private String name;
    private String phone;
    
    public CheckingAccountDto() {}
	public CheckingAccountDto(long accountNumber, String name, String phone) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "CheckingAccountDto [accountNumber=" + accountNumber + ", name=" + name + ", phone=" + phone + "]";
	}
}
