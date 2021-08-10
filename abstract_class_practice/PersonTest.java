  package abstract_class_practice;
/**
 * @version 123456
 * @author 54321
 */
  
  public class PersonTest
  {

  	public static void main(String[] args)
  	{
  		PersonRepo people = new PersonRepo();
  		people.addStudent("Maria", "computer science");
        people.addEmployee("David", 65000, 1992, 11, 8);
        people.addStudent("Lee", "mathmetics");
        people.addStudent("Carl", "physics");
        people.addEmployee("Nancy", 70000, 1988, 2, 1);
        people.addEmployee("John", 30000, 1989, 4, 16);
        System.out.println("###Original ArrayList:###");
        people.listPerson();
      
        // 应该赋值
        AbsPerson m = people.findByName("Nancy");
        
        people.findPerson("Carl");
        
        System.out.println("###Student(s):###");
        people.listStudent();
        
        people.removePerson("Nancy");//Remove Nancy
        people.editPerson("Harry", 65000, 1989, 11 ,1);
        people.editPerson("Lee", "philosophy");
        System.out.println("###Edited ArrayList:###");
        people.listPerson();
        
        people.findPerson("Lee");
        people.addPerson(m);
        System.out.println("###Add Nancy Again###");
        people.listPerson();
        
  	}
  }
  	   
  		/*PersonRepository.addEmployee("Harry", 50000, 1989, 10, 1);
  		PersonRepository.addStudent("Maria", "computer science");
  		PersonRepository.addEmployee("David", 65000, 1992, 11, 8);
		PersonRepository.addStudent("Lee", "mathmetics");
		PersonRepository.addStudent("Carl", "physics");
		PersonRepository.addEmployee("Nancy", 70000, 1988, 2, 1);
		PersonRepository.addEmployee("John", 30000, 1989, 4, 16);
		System.out.println("Original ArrayList:");
		PersonRepository.listPerson("bio");
		
		// 应该赋值
  		PersonRepository.findByName("Maria");
  		
  		System.out.println("Student(s):");
  		PersonRepository.listPerson("student");
  		
  		PersonRepository.removePerson("Nancy");//Remove Nancy
  		
  		PersonRepository.editPerson("Harry", 65000, 1989, 11 ,1);
  		PersonRepository.editPerson("Lee", "philosophy");
  		System.out.println("Edited ArrayList:");
  		PersonRepository.listPerson("bio");
  		*/