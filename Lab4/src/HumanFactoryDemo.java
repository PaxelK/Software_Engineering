import human.Human;



public class HumanFactoryDemo {

	public static void main(String[] args) {
		//HumanFactory humanfac = new HumanFactory();
		
		
		Human billie = Human.create("Billie", "xxxxxx-xx0x");
		Human anna = Human.create("Anna", "xxxxxx-xx2x");
		Human magnus = Human.create("Magnus","xxxxxx-xx1x");
		
		
		
		
		Human h = new Human();	
		System.out.println(h);
		
		
		
		System.out.println(billie);
		System.out.println(anna);
		System.out.println(magnus);	
		
	
	
	}

}
