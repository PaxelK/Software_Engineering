	
public class Leaf extends Component{
	
	Leaf(String compName, int compWeight){
		name = compName;
		weight = compWeight;
		
	}

	public String toString() {
		String temp = name + " [" + Integer.toString(this.getWeight()) + "kg], ";
		return temp;
	}
	
	int getWeight() {
		return weight;
	}

	public static void main(String[] args) {
		Leaf leaf = new Leaf("Wallet", 100);
				System.out.println(leaf.toString());
	}

}
