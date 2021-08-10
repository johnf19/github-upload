package stream_practice;

import java.util.List;
import java.util.Optional;
import java.util.stream.*;
import java.util.ArrayList;

public class PersonRepo 
{
		private List<Person> people = new ArrayList<>();
		
		// 命名不够好
		public List<Person> listPeople()
		{
			return people;
		}
		
		// 很好
		// 可直接return，不用sum中间变量
		public int totalNumOfFruits() {
			 return people.stream()
					 .map(n -> n.numOfFruits())
					 .reduce(0, (a, b) -> a + b);
		}
		
		private final void isLegal(String arg)
		{
			if (findByName(arg) != null && findByName(arg).toString().equals(arg)|| arg == null)
				throw new IllegalArgumentException("Bad Argument\""+ arg + " is a duplicated name or null\"!");
		}
		
		public void updateName(String originalname, String name)
		{
			// 下面这行代码在addEmployee中重复使用，可以写成private小函数
			isLegal(name);
			findByName(originalname).updateName(name);;
		}
		
		public final void addEmployee(String name, int salary, int hireDD, int hireMM, int hireYY)
		{
			isLegal(name);
			people.add(new Employee(name, salary, hireDD, hireMM, hireYY));
			//listPerson();
		}
		
		public final void addStudent(String name, String description)
		{
			isLegal(name);
			people.add(new Student(name, description));
			//listPerson();
		}
		
		public final List<Person> removePersonToNewList(String name)
		{
			List<Person> returnlist = people.stream()
					.filter(n -> !n.getName().equals(name))
					.collect(Collectors.toList());
			return returnlist;
		}
		
		public final void removePerson(String name)
		{
			people.removeIf(n -> n.getName().equals(name));
		}
		
		public final List<Person> listEmployee()
		{
			List<Person> returnlist = people.stream()
					.filter(n -> n.getType() == 2)
					.collect(Collectors.toList());
			return returnlist;
		}
		
		public final List<Person> listStudent()
		{
			List<Person> returnlist = people.stream()
					.filter(n -> n.getType() == 1)
					.collect(Collectors.toList());
			return returnlist;
		}
		
		public final Person findByName(String name)
		{	
			Optional <Person> p = people.stream()
				.filter(n -> n.getName().equals(name))
				.findAny(); // 考虑使用.findFirst() + orElse(null)取消下面的if
			if (p.isPresent())
				return p.get();
			return null;			
		}
		
		public final String findPerson(String name)
		{
			return findByName(name).toString();
		}
		
		/*public final List<Person> listEmployee()
		{
			List<Person> returnlist = new ArrayList<>();
			for (Person p : people)
				if (p instanceof Employee)
				{
					System.out.println(p.getName());
					returnlist.add(p);
				}
			return returnlist;
		}*/
		
		/*public final List<Person> listStudent()
		{
			List<Person> returnlist = new ArrayList<>();
			for (Person p : people)
				if (p instanceof Student)
				{
					System.out.println(p.getName());
					returnlist.add(p);
				}
			return returnlist;
		}
		*/
		//Any better method?
		
		// 函数名应更确切
		/*public final List<String> listPerson()
		{
			List<String> returnlist = new ArrayList<>();
			for (Person p : people)
			{
				//System.out.println(p.toString());
				returnlist.add(p.toString());
			}
			return returnlist;
		}
		*/
		
		/*public final Person findByName(String name)
		{
			for (Person p : people)
			{
				if(name.equals(p.getName())) 
					return p;			
			}
			return null;				
		}
		
		public final String findPerson(String name)
		{
			return findByName(name).toString();
		}*/


		
		// 接口设计上有了下面两个接口，这个没必要
				// 这个final表示addPerson不能被override，因为没有继承结构意义不大
				// 可考虑(final Person p)，表示参数p不能被函数修改
				// 参数p有隐含条件: p != null，可通过if、assert、@NonNull标注等
				// 参数p另一隐含条件是name不能重复，否则findByName()就有问题，考虑使用抛异常
				/*public final void addPerson(final Person p)
				{
					people.add(p);
				}
				*/
		
		
		// 这个接口不太容易使用
		// 已有findByName就够了，然后Person上增加更改属性的接口
		/*public void editPerson(String name, Object ... param)
		{
			int range = people.size();
			for (int i = 0; i < range; i++)
			{
				if (name == people.get(i).getName())
				{
					if(people.get(i) instanceof Student)
					{
						people.remove(i);
						addStudent(name, (String)param[0]);
					}
					else if(people.get(i) instanceof Employee)
					{
						people.remove(i);
						addEmployee(name, (int)param[0], (int)param[1], (int)param[2], (int)param[3]);
					}
				}
			}
		}
		*/
}
