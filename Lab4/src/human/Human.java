package human;

public abstract class Human {
	String name;
	String num;
	
	Human (){};
	
	public abstract String toString();
	
	  
	public static Human create(String name, String num) {
		String temp = num.substring(9, 10);
		int pnrInt = Integer.parseInt(temp);
		
		if (pnrInt == 0) {
			System.out.println(pnrInt);

			return new NonBin(name, num);
		}
		
		else if ((pnrInt)%2==0) {
			System.out.println(num.charAt(num.length()-2));

			return new Woman(name, num);
		}
		
		else if (pnrInt%2==1) {
			System.out.println(num.charAt(num.length()-2));
			return new Man(name, num);
		}
		return null;
		
	}
	
}
