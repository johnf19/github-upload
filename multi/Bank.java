package multi;

import java.util.List;

public interface Bank 
{
	double getBalance(String name);
	
	void addAccount(String name, double balance);
	
	void removeAccount(String name);
	
	void freezeAccount(String name);
	
	void importFromPerson(PersonRepo personRepo, int workTimeInMonth);
	
	void transfer(String fromThisAccountName, int amountBiggerThanZero, String toThisAccountName) throws InterruptedException;
	
	void addBalance(String name, double amountBiggerThanZero);
	
	void withdrawBalance(String name, double amountBiggerThanZero);
	
	List<Account> listAccount();
}
