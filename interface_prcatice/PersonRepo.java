package interface_prcatice;

import java.util.List;

import stream_practice.Employee;
import stream_practice.Person;
import stream_practice.Student;

import java.util.ArrayList;

public class PersonRepo 
{
		// 这个final表示people不能被重新赋值
		// 类型用List<Person>更好，List是ArrayList的接口，符合code on interface
	
		private List<Person> people = new ArrayList<>();
		
		public List<Person> listList()
		{
			return people;
		}
		
		// TODO 多态的应用
		public int totalNumOfFruits() {
			// TODO 计算所有人所需的水果数量
			int sum = 0;
			for (Person p : people)
				sum += p.numOfFruits();
			return sum;
		}
		
		public void updateName(String originalname, String name)
		{
			for (Person p : people)
			if(p.getName().equals(name) || p == null)
				throw new IllegalArgumentException("Bad Argument\""+ name + " is a duplicated name or null\"!");
			findByName(originalname).updateName(name);;
		}
		
		// Integer是类，int是基本类型，一般地int即可
		public final void addEmployee(String name, int salary, int hireDD, int hireMM, int hireYY)
		{
			for (Person p : people)
				if(p.getName().equals(name) || p == null)
					throw new IllegalArgumentException("Bad Argument\""+ name + " is a duplicated name or null\"!");
			people.add(new Employee(name, salary, hireDD, hireMM, hireYY));
			//listPerson();
		}
		
		public final void addStudent(String name, String description)
		{
			for (Person p : people)
				if(p.getName().equals(name) || p == null)
					throw new IllegalArgumentException("Bad Argument\""+ name + " is a duplicated name or null\"!");
			people.add(new Student(name, description));
			//listPerson();
		}
		
		public final void removePerson(String name)
		{
			for (int i = 0; i < people.size(); i++)
			{
				if(name.equals(people.get(i).getName()))
				people.remove(i);
			}
		}
		
		public final List<Person> listEmployee()
		{
			List<Person> returnlist = new ArrayList<>();
			for (Person p : people)
				if (p instanceof Employee)
				{
					System.out.println(p.getName());
					returnlist.add(p);
				}
			return returnlist;
		}
		
		public final List<Person> listStudent()
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
		
		public final Person findByName(String name)
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
		}


		
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
