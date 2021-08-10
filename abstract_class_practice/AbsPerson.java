package abstract_class_practice;


public abstract class AbsPerson implements Person
{
	private String name;
	
	public abstract String getBio();
	
	public abstract int getType();
	
	public abstract String toString();
	
	public AbsPerson(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
