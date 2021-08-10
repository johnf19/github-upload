package read_write_lock;

public class TestMain 
{
	public static void main(String[] args)
	{
		//RunnableDemo R1 = new RunnableDemo( "Thread-1");
		//R1.start();
		      
		//RunnableDemo R2 = new RunnableDemo( "Thread-2");
		//R2.start();   

		PersonRepo people = new PersonRepo();
		new Thread(() -> {
			people.addEmployee("Bill Gates", 65000, 1989, 11 ,1);	
		}).run();;
		Thread T1 = new Thread(() -> people.addStudent("Jeff Bezos", "computer science"));
		Thread T2 = new Thread(() -> people.addEmployee("Elon Mask", 65000, 1992, 11, 8));
		new Thread(() -> people.addStudent("Bernald Arnalt", "mathmetics")).start();;
		new Thread(() ->  people.addStudent("Mark Zuckerberg", "physics")).start();;
		new Thread(() -> people.addEmployee("Warren Buffet", 70000, 1988, 2, 1)).start();;
		
		T1.start();
		T2.start();
  		
        
        
       
        
        people.addEmployee("Mukesh Ambani", 30000, 1989, 4, 16);

        //System.out.println("###Original ArrayList:###");
        //System.out.println(people.listPeople());
        
       // System.out.println("###apples:###");
       // System.out.println(people.totalNumOfFruits());
        //System.out.println("###Student(s):###");
        //System.out.println(people.listStudent());
        
       // System.out.println("###Edited ArrayList:###");
       // people.removePerson("Warren Buffet");//Remove Nancy
        //people.findByName("Mukesh Ambani").updateElements(65000, 1989, 11 ,1);
        //people.findByName("Jeff Bezos").updateElements("philosophy");
       // System.out.println(people.listPeople());
        
        Deposit bank = new Deposit();
        bank.importFromPerson(people, 10);
        System.out.println(bank.listAccount());
        Thread T3 = new Thread(() -> {bank.transfer("Bill Gates", 700000, "Bernald Arnalt");System.out.println("Output lambda: " + bank.listAccountAlter());});
        Thread T4 = new Thread(() -> bank.addBalance("Bill Gates", 100000));
        T3.start();
        T4.start();
        System.out.println("Output 1: " + bank.listAccount()); //not run on expected time.
        System.out.println("Output 2: " + bank.listAccountAlter());//same method as listAccount but will acquire a lock, still run early on time
	}
}
