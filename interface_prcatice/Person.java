package interface_prcatice;

public interface Person
{	
	String getName();
	
	String getBio();
	
	int getType();

	// TODO 类似接口，代替editPerson
	void updateName(String newName);
	
	void updateElements(Object ... elements);
	
	// 考虑增加接口，返回不同的水果数量
	int numOfFruits();

	String toString();
	
}

