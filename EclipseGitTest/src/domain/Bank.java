package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

	private List<BankAccount> accounts;
	
	public Bank() {
		accounts = new ArrayList<>();
	}
	
	public void add(BankAccount a) {
		accounts.add(a);
	}
	
	public void clear() {
		accounts.clear();
	}
	
	public void remove(BankAccount a) {
		accounts.remove(a);
	}
	
	public void remove(BankAccount... accounts) {
		for(BankAccount a: accounts) {
			remove(a);
		}
	}
	
	public void add(BankAccount...accounts ) {
		for(BankAccount a: accounts) {
			remove(a);
		}
	}
	
	public List<BankAccount> getAccounts(){
		return Collections.unmodifiableList(accounts);
	}
	
	public String toString() {
		return "Bank [accounts= " + accounts + "]";
	}
	
}