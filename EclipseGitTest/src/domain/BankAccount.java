package domain;


import java.time.LocalDateTime;

public class BankAccount {
	
	private Long 			accountNumber;
	private LocalDateTime	openingDate;
	private String			firstName;
	private Double 			amount;
	private Double 			creditLimit;
	
	
	public BankAccount(Long accountNumber, LocalDateTime openingDate, String firstName, Double amount, Double creditLimit) {
		
			setAccountNumber(accountNumber);
			setFirstName(firstName);
			setAmount(amount);
			setOpeningDate(openingDate);
			setCreditLimit(creditLimit);
	}


	public LocalDateTime getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Double getCreditLimit() {
		return creditLimit;
	}


	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String toString() {
		return "Account [AccountNumber= " + accountNumber + ", openingDate= " + openingDate + ", firstName= " + firstName + "!";
	}
}
