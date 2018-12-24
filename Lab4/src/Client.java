
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Client {
	static String[] leafNames= {"Toothbrush", "Shampoo", "Glasses", "Chewing gum", "Laptop", "Water bottle", "Map", "Toothpaste"};
	static String[] containerNames = {"Backpack", "Fanny pack", "Bag", "Pants"};
	

	
	Client(){
 
		
	}
	public static void main(String args []) {
		ArrayList<Container> containers = new ArrayList<Container>();
		ArrayList<Leaf> leafs = new ArrayList<Leaf>();
		
		int totalLeaves = 10;
		int totalContainers = 5;
		Random r = new Random();
		int tempRandom;

		
		for (int i = 0; i < leafNames.length; i++) {
			Leaf temp = new Leaf(leafNames[i], i);			
			leafs.add(temp);	
		}
		
		
		for (int i = 0; i < containerNames.length; i++) {
			Container temp = new Container(containerNames[i], i);			
			containers.add(temp);
		}
		/*
		for (int i = 0; i < leafs.size(); i++) {
			tempRandom = r.nextInt(containers.size());
			containers.get(tempRandom).add(leafs.get(i));
		}
		*/
		containers.get(0).add(leafs.get(0));
		containers.get(0).add(leafs.get(1));
		containers.get(0).add(leafs.get(2));
		containers.get(1).add(leafs.get(3));
		containers.get(1).add(leafs.get(4));
		containers.get(2).add(leafs.get(5));
		containers.get(3).add(leafs.get(6));
		containers.get(3).add(leafs.get(7));
		
		/*
		for (int i = 0; i < totalContainers; i++) {
			System.out.println(containers.get(i));
		}
		*/
		
		Component suitcase = new Container("Suitcase", 2);
		for (int i = 0; i < containers.size(); i++) {
			((Container)suitcase).add(containers.get(i));
		}
		System.out.println(suitcase);
		//suitcase.remove();
		//System.out.println(suitcase);
		
	}
}