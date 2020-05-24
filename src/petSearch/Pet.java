package petSearch;

public class Pet{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Pet() {
		name = "None given";
		age = 0;
	}
	public Pet (String initName, int initAge) {
		name = initName;
		age=initAge;
	}
}
