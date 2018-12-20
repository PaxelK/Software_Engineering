package human;

public class NonBin extends Human{
	String name;
	String num;
	
	NonBin(String name, String num) {
		this.name=name;
		this.num=num;	
		}
	
	public String toString() {
		String tempName = "I am a nonbin, and my name is " + name + ".";
		return tempName;
	}
	/*
	public Human create(String name, String num) {
		Human nonbin = new NonBin(name, num);
		return nonbin;
	}
*/
}
