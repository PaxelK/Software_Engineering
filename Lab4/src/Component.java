
public abstract class Component {
	String name;
	int weight;
	
	Component (){
		
		
	}
	public abstract String toString();
	abstract int getWeight();
	abstract void add(Component c);
	abstract void remove(Component c);


	
	
	public static void main(String[] args) {
		
	}
}
