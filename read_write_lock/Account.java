package read_write_lock;


public class Account 
{
	private String name;
	private double balance = 0;
	public Account(String name, double balance)
	
	{
		this.name = name;
		this.balance = balance;
	}
	
	
	public final void addBalance(double amount)
	{
		balance += amount;
	}
	
	public final void reductBalance(int amount)
	{
		balance -= amount;
	}
	
	public final double getBalance()
	{
		return balance;
	}
	
	public final String getName()
	{
		return name;
	}
	
	public final String toString()
	{
		return name + " " + balance;
	}
}
