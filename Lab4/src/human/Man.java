package human;

public class Man extends Human {
	String name;
	String num;
	
	protected Man(String name, String num) {
		this.name=name;
		this.num=num;
	}
	
	public String toString() {
		String tempName = "I am a man, and my name is " + name + ".";
		return tempName;
	}
	
/*
	public Human create(String name, String num) {
		Human man = new Man(name, num);
		
		return man;
	}*/
	
}
