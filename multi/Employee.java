package multi;
import java.time.*;

public class Employee implements Person
{
	private double salary;
	private String name;
	private LocalDate hireDay;
	private int apple = 2;
	private String gender;

	
	public boolean isMale()
	{
		if (gender.equals("male"))
			return true;
		return false;
	}
	
	public void addApple()
	{
		apple += 2;
	}
	
	public int getType()
	{
		return 2;
	}
	
	public int numOfFruits() //same function as getType, is it ok?
	{
		return apple;
	}
	
	public void updateName(String name)
	{
		this.name = name;
	}
	
	public void updateElements(Object ... e)
	{
		this.salary = (int)e[0];
		this.hireDay = LocalDate.of((int)e[1], (int)e[2], (int)e[3]);
	}
	
	public Employee(String name, double salary, int year, int month, int day)
	{
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, day);
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public LocalDate getHireDay()
	{
		return hireDay;
	}
	
	public String getBio()
	{
		return String.format(" an employee with a salary of $%.2f", salary);
	}
	
	public String getName()
	{
		return name;
	}

	public String toString()
	{
		// 中间需空格分割*
		return this.getName()+ " " + salary + " " + hireDay;
	}
}
