package abstract_class_practice;
import java.time.*;

public class Employee extends AbsPerson
{
	private double salary;

	private LocalDate hireDay;

	public int getType()
	{
		return 2;
	}

	public Employee(String name, double salary, int year, int month, int day)
	{
		super(name);
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

	// TODO 该接口设计错误，应该是PersonRepository中的方法*
	// TODO 功能实现也有问题，总是返回只有一个元素的List，无实际作用*
	/*public static ArrayList<AbsPerson> addPeople(AbsPerson p)
	{
		// 类型定义使用List<Person>接口，不要使用具体类*
		ArrayList<AbsPerson> list = new ArrayList<>();
		list.add(p);
		return list;
	}*/

	// 从功能上看，可重载toString()

	public String toString()
	{
		// 中间需空格分割*
		return this.getName()+ " " + salary + " " + hireDay;
	}
}
