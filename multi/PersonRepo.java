package multi;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.*;
import java.util.ArrayList;


// 加锁实现基本正确，进一步考虑：
// - 使用ReadWriteLock读写锁
// - synchronized关键字的用法，和Lock的异同

public class PersonRepo
{
		private List<Person> people = new ArrayList<>();
		private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		private final Lock r = rwLock.readLock();
		private final Lock w = rwLock.writeLock();
		
		
		// 命名不够好
		public List<Person> listPeople()
		{
			// TODO 读也要加锁，所有读接口均是
			w.lock();
			try
			{
				return people;
			}
			finally
			{
			w.unlock();
			}
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
			if (findByName(name) != null && !findByName(name).toString().equals(name)|| name == null)
				throw new IllegalArgumentException("Bad Argument\""+ name + " is a duplicated name or null\"!");
			w.lock();
			try
			{
				findByName(originalname).updateName(name);
			}
			// 万一上面那行代码抛出异常，则unlock()就不会执行到
			// 考虑使用try...catch...finally
			finally
			{
			w.unlock();
			}
		}
		
		public final void addEmployee(String name, int salary, int hireDD, int hireMM, int hireYY)
		{
			isLegal(name);
			r.lock();
			w.lock();
			try 
			{
				people.add(new Employee(name, salary, hireDD, hireMM, hireYY));
			}
			finally
			{
				w.unlock();
				r.unlock();
			}
			//listPerson();
		}
		
		public final void addStudent(String name, String description)
		{
			isLegal(name);
			r.lock();
			w.lock();
			try
			{
				people.add(new Student(name, description));
			}
			finally
			{
				w.unlock();
				r.unlock();
			}
			//listPerson();
		}
		
		/*public final List<Person> removePersonToNewList(String name)
		{
			List<Person> returnlist = people.stream()
					.filter(n -> !n.getName().equals(name))
					.collect(Collectors.toList());
			return returnlist;
		}*/
		
		public final void removePerson(String name)
		{
			r.lock();
			w.lock();
			try
			{
				people.removeIf(n -> n.getName().equals(name));
			}
			finally
			{
				w.unlock();
				r.unlock();
			}
		}
		
		public final List<Person> listEmployee()
		{
			r.lock();
			try 
			{
				List<Person> returnlist = people.stream()
						.filter(n -> n.getType() == 2)
						.collect(Collectors.toList());
				return returnlist;
			}
			finally
			{
				r.unlock();
			}
		}
		
		public final List<Person> listStudent()
		{
			r.lock();
			try
			{
				List<Person> returnlist = people.stream()
						.filter(n -> n.getType() == 1)
						.collect(Collectors.toList());
				return returnlist;
			}
			finally
			{
				r.unlock();
			}
		}
		
		public final Person findByName(String name)
		{	
			Person p = people.stream()
				.filter(n -> n.getName().equals(name))
				.findFirst()
				.orElse(null);// 考虑使用.findFirst() + orElse(null)取消下面的if
			return p;			
		}
		
		public final String findPerson(String name)
		{
			r.lock();
			try
			{
				return findByName(name).toString();
			}
			finally
			{
				r.unlock();
			}
		}
		
		public final Person findByNameM(String name)
		{
			return null;
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
