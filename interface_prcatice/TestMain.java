package interface_prcatice;

public class TestMain {
	public static void main(String[] args)
	{
		PersonRepo people = new PersonRepo();
		people.addEmployee("Harry", 65000, 1989, 11 ,1);
  		people.addStudent("Maria", "computer science");
        people.addEmployee("David", 65000, 1992, 11, 8);
        people.addStudent("Lee", "mathmetics");
        people.addStudent("Carl", "physics");
        people.addEmployee("Nancy", 70000, 1988, 2, 1);
        people.addEmployee("John", 30000, 1989, 4, 16);
        System.out.println("###Original ArrayList:###");
        people.listList();
      
        // 应该赋值
        
        people.addEmployee("Peter", 90000, 1985, 3, 8);
        
        System.out.println("###Student(s):###");
        people.listStudent();
        
        people.removePerson("Nancy");//Remove Nancy
        System.out.println(people.listList());
        people.findByName("Maria").updateName("Harry");
        people.findByName("Harry").updateElements(65000 ,1989 ,11 , 1);
        System.out.println("###Edited ArrayList:###");
        people.listList();
        System.out.println("Apples: " + people.totalNumOfFruits());
        people.updateName("Harry","David");
        /*people.editPerson("Harry", 65000, 1989, 11 ,1);
         * people.findPerson("Carl");
        people.editPerson("Lee", "philosophy");
        
        people.listPerson();
        people.addPerson(m);
        
        people.findPerson("Lee");
        
        System.out.println("###Add Nancy Again###");
        
        */
        
	}
}
