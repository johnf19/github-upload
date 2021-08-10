package read_write_lock;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;

public class Deposit implements Bank
{
	private List<Account> account = new ArrayList<>();
	private final Lock accountLock = new ReentrantLock();
	private final Condition sufficientFunds = accountLock.newCondition();
	
	public final synchronized void addAccount(String name, double balance)
	{
		accountLock.lock();
		account.add(new Account(name, balance));
		accountLock.unlock();
	}
	
	public final synchronized void addBalance(String name, double balance)
	{
		accountLock.lock();
		try
		{
			findByName(name).addBalance(balance);
			System.out.println("add funds!");
			sufficientFunds.signalAll();
		}
		finally
		{
			accountLock.unlock();
		}
	}
	
	public final synchronized void withdrawBalance(String name, double balance)
	{
		accountLock.lock();
		findByName(name).addBalance(-balance);
		accountLock.unlock();
	}
	
	public final synchronized void removeAccount(String name)
	{
		accountLock.lock();
		account.removeIf(n -> n.getName().equals(name));
		accountLock.unlock();
	}
	
	public final void freezeAccount(String name)
	{
		
	}
	
	public final void importFromPerson(PersonRepo repo, int month)
	{
		accountLock.lock();
		for (Person p : repo.listPeople())
		{
			addAccount(p.getName(), p.getSalary()*month);
		}
		accountLock.unlock();
	}
	
	public final synchronized void transfer(String a1, final int i1, String b1)
	{
		if (i1 < 0)
			throw new IllegalArgumentException("Can Not Transfer This Amount!");
		accountLock.lock();
		try
		{
			if (getBalance(a1) < i1)
				System.out.println("insufficient funds!");
				sufficientFunds.await();
			System.out.println("transfered!");
			findByName(a1).reductBalance(i1);
			findByName(b1).addBalance(i1);
			sufficientFunds.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			accountLock.unlock();
			//System.out.println(listAccount());
		}
	}
	
	public final synchronized double getBalance(String name)
	{
		if (findByName(name) == null)
			throw new IllegalArgumentException("Bad Argument\""+ name + " No This Person\"!");
		return findByName(name).getBalance();
	}
	
	private synchronized final Account findByName(String name)
	{	
		Account p = account.stream()
			.filter(n -> n.getName().equals(name))
			.findFirst()
			.orElse(null);
		return p;			
	}
	
	
	public synchronized List<Account> listAccount()
	{
		return account;
	}
	
	public synchronized List<Account> listAccountAlter()
	{
		accountLock.lock();
		try
		{
			return account;
		}
		finally
		{
			accountLock.unlock();
		}
	}
	

}
