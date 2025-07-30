package com.example.demo.dto;

import lombok.Data;

@Data
public class bankAccountDTO {
	  public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	private String accountNumber, bankName;
}
