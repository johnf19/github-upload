package stream_practice;

public class TestMain 
{
	public static void main(String[] args)
	{

		PersonRepo people = new PersonRepo();
		people.addEmployee("Bill Gates", 65000, 1989, 11 ,1);
  		people.addStudent("Jeff Bezos", "computer science");
        people.addEmployee("Elon Mask", 65000, 1992, 11, 8);
        people.addStudent("Bernald Arnalt", "mathmetics");
        people.addStudent("Mark Zuckerberg", "physics");
        people.addEmployee("Warren Buffet", 70000, 1988, 2, 1);
        people.addEmployee("Mukesh Ambani", 30000, 1989, 4, 16);

        System.out.println("###Original ArrayList:###");
        System.out.println(people.listPeople());
        
        System.out.println("###apples:###");
        System.out.println(people.totalNumOfFruits());
        System.out.println("###Student(s):###");
        System.out.println(people.listPeople());
        
        System.out.println("###Edited ArrayList:###");
        people.removePerson("Warren Buffet");//Remove Nancy
        people.findByName("Mukesh Ambani").updateElements(65000, 1989, 11 ,1);
        people.findByName("Jeff Bezos").updateElements("philosophy");
        System.out.println(people.listPeople());
        
        
		
		
	}
}
