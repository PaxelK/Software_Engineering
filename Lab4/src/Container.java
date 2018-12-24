import java.util.ArrayList;
import java.util.ListIterator;

public class Container extends Component{
	ArrayList<Component> children;
	ListIterator it;
	String totalname;
	
	Container (String ContainerName, int containerWweight){
		name = ContainerName;
		weight = containerWweight;
		children = new ArrayList<Component>();
		it = children.listIterator();
		
	}
	
	public String toString() {

		String totalName = name + " [" + Integer.toString(this.getWeight()) +" kg in total] and contains: ";
		it = children.listIterator();
		
		if (children.isEmpty()) {
			return totalname += " nothing.";
		}
		else
			while (it.hasNext()) {
				totalName += it.next().toString();
				totalName += '\n';

			}
		totalName = totalName.substring(0, totalName.length()-2);
		return totalName;
	}
	

	int getWeight() {
		int totalWeight = weight;
		it = children.listIterator();
		
		if (children.isEmpty()) {
			return totalWeight;
		}
		else
			while (it.hasNext()) {
				Component temp = (Component) it.next();
				totalWeight += temp.getWeight();
				}
			
		return totalWeight;
	}
	
	
	
	void add(Component child) {
		children.add(child);
	}
	
	void remove(Component child) {			
		if (!children.remove(child)) {
			for(Component c: children) {
				if(c instanceof Container) {
					((Container) c).remove(child);
				}
				
			}
		}

	}
	
	/*
	Component getChild() {
		return child;	
	}
	 */
	
	public static void main(String[] args) {
		Component testC = new Container("Pants", 10);
		Component testC2 = new Container("Safe", 10);

		Component leaf1 = new Leaf("wallet", 5);
		Component leaf2 = new Leaf("comb", 2);
		Component leaf3 = new Leaf("papers", 100);
		Component leaf4 = new Leaf("money", 1000);

		testC.add(leaf1);
		testC.add(leaf2);
		testC2.add(leaf3);
		testC2.add(leaf4);
		testC2.add(testC);

		System.out.println(testC2.toString());
		testC2.remove(leaf2);
		System.out.println(testC2.toString());

		
		
	}
	

}
