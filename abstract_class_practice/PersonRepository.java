package abstract_class_practice;

/*import java.util.ArrayList;*/

public class PersonRepository
{
	
}
	// protected一般用于继承结构，此处无继承，private更恰当*
	// 使用static确保全局只有一个List是可以的，但是可以new任意多个PersonRepository
	// 如果要确保全局一个实例，使用Singleton模式限制只有一个PersonRepository更好
	// 类型尽量使用接口，List<Person>
	/*private static ArrayList<AbsPerson> people = new ArrayList<>();
	
	// 使用Singleton模式限制一个实例，方法不必是static的
	// 了解Integer和int类型的区别
	// 函数参数可以加final，表示只读、不会被函数修改*
	public static final void addEmployee(String name, Integer salary, Integer hireDD, Integer hireMM, Integer hireYY)
	{
		people.add(new Employee(name, salary, hireDD, hireMM, hireYY));
		//listPerson();
	}
	
	public static final void addStudent(String name, String description)
	{
		people.add(new Student(name, description));
		//listPerson();
	}
	
	public static final void removePerson(String name)
	{
		for (int i = 0; i < people.size(); i++)
		{
			// 了解==和equals的区别，即引用相同还是内容相同?
			if(name == people.get(i).getName())
			people.remove(i);
		}
	}
	
	// 返回Person类型
	public static final AbsPerson findByName(String name)
	{
	//	if (people.size() == 0)
		//	people.add(new Student("No", "Person"));
		for (AbsPerson p : people)
		{
			if(name == p.getName()) // ==问题
				return p;				// 可以直接return p*
		}
		//System.out.println(ps);
		return null;					// 此处return null*
	}
	
	// 使用参数取值不同表明不同含义的接口设计不好，可以拆分成多个命名清晰的函数
	// 特别的代码中区分"student"、"employee"是不对的，需重点理解面向对象的多态概念，这是OO设计的关键之处
	// 该接口应该有List<Person>或List<String>的返回值，仅打印出来实际上无法使用
	
	
	
	
	/*public static void listPerson(String type)
	{
		for (AbsPerson p : people)
			if (type == "bio")
				System.out.println(p.getName() + "," + p.getBio() + ".");
			else if(type == "student")
				{
					if(1 == p.getType())
						System.out.println(p.getName());
				}
			else if(type == "employee")
			{
				if(2 == p.getType())
					System.out.println(p.getName());
			}
			else if(type == "name")
				System.out.println(p.getName());
			else if(type == p.getName())
				System.out.println(p.getName() + "," + p.getBio() + ".");
	}
	
	public static void listPerson()
	{
		listPerson("name");
	}
	*/
	
	// 这个接口设计也很容易误用，同上应设计命名清晰的函数
	// 可考虑拆分为先findByName返回Person，再调用Person上的updateName等方法
	
	/*public static void editPerson(String name, Object ... param)
	{
		int range = people.size();
		for (int i = 0; i < range; i++)
		{
			int typ = 0;
			if (name == people.get(i).getName())
			{
				typ = people.get(i).getType();
				people.remove(i);
				if(typ == 1)
					PersonRepository.addStudent(name, (String)param[0]);
				else if(typ == 2)
					PersonRepository.addEmployee(name, (int)param[0], (int)param[1], (int)param[2], (int)param[3]);
				//listPerson("bio");
			}
		}
	}
	
	
}
*/

	
	
