package multi;

public class Student implements Person
{
	private String major;
	private String name;
	private int apple = 1;
	private String gender;

	public final double getSalary()
	{
		return 0;
	}
	
	public boolean isMale()
	{
		if (gender.equals("male"))
			return true;
		return false;
	}
	
	public void addApple()
	{
		apple += 1;
	}
	
	public int getType()
	{
		return 1;
	}
	
	public int numOfFruits()
	{
		return apple;
	}
	
	public void updateName(String name)
	{
		this.name = name;
	}
	
	public void updateElements(Object ... e)
	{ 
		this.major = (String)e[0];
	}
	
	public Student(String name, String major)
	{
		this.name = name;
		this.major = major;
	}
	
	
	public String getBio()
	{
		return " a student majoring in " + major;
	}
	
	public String toString()
	{
		return this.getName()+ " " + major;
	}
	
	public String getName()
	{
		return name;
	}
}
