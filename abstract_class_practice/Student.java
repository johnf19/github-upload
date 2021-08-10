package abstract_class_practice;

public class Student extends AbsPerson 
{
	private String major;
	
	public int getType()
	{
		return 1;
	}
	
	public Student(String name, String major)
	{
		super(name);
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
}
