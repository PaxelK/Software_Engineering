package human;

public class Woman extends Human{
	String name;
	String num;
	
	protected Woman(String name, String num) {
		this.name=name;
		this.num=num;
		}
	
	public String toString() {
		String tempName = "I am a woman, and my name is " + name + ".";
		return tempName;
	}
/*
	public Human create(String name, String num) {
		Human woman = new Woman(name, num);
		return woman;
	}
*/
		
}
