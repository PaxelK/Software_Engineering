import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.*;

public class TreeOfLife extends TreeFrame{
	
	/*
	 * HEJ KAJ!!!
	 */
	
	ArrayList<treeNode> children;
	ArrayList<String> filelist;
	
    void initTree() {
		root = new treeNode("Life", "World Tree");
		treeModel = new DefaultTreeModel( root );
		/*
		treeNode plants = new treeNode("Plants");
		treeNode animals = new treeNode("Animals");
		treeNode mushrooms = new treeNode("Mushrooms");
		
		treeNode flower = new treeNode("Vitsippa");
		treeNode deer = new treeNode("Kronhjort");
		treeNode redMush = new treeNode("Flugsvamp");
		
		plants.add(flower);
		animals.add(deer);
		mushrooms.add(redMush);
		
		children.add(plants);
		children.add(animals);
		children.add(mushrooms);
		*/
		children = new ArrayList<treeNode>();
		tree = new JTree( treeModel );

    	filelist = new ArrayList<String>();

    	try {
			 Scanner sc = new Scanner(new File("C:\\Users\\Axel Karlsson\\Documents\\GitHub\\Software_Engineering\\Lab5SEgit\\src\\Life.txt"));
				while (sc.hasNextLine()){
		    		String line = sc.nextLine();
		    		filelist.add(line);
				}
    	
    	}
		catch (FileNotFoundException sc) {}
    	
    	treeNode currentTopNode;
    	String currentTop = "";
    	String temp = "";
    	
    	buildFamilies(filelist, root);
    	
		//buildTree();
    }

    // New method
    private void buildFamilies(ArrayList<String> textRest, treeNode Parent) {  	
    	
    	if(textRest.isEmpty()) {
    		return;
    	}
    	String line = textRest.get(0);
    	textRest.remove(0);
    	
    	Boolean newType = true;
    	//GETS THE HIERARCHY TYPE
    	String[] typeArr = line.split("\\s", 2);
		String type = typeArr[0].replaceFirst("<", "");
		
		//Takes the NAME which is enveloped by "" and creates a node with it.
		String nodeName = "";
		if(line.contains("\"")){
			String[] infoArr = line.split("\"");
			nodeName = infoArr[1];
			
			//Takes the description
			String nodeDescr = infoArr[2];
			
		}
		
		
		
		
		treeNode tempNode = new treeNode(nodeName, type);
		
		if(Parent.getType().equals(type)) {
			//AVBRYT. D� �R VI L�V
			buildFamilies(textRest, (treeNode) Parent.getParent());
			newType = false;
		}
		treeNode tempParent = Parent;
		while(tempParent.getParent()!=null) {
			if(tempParent.getType().equals(type)) {
				
				buildFamilies(textRest, (treeNode) tempParent.getParent());
				newType = false;
			}
			tempParent = (treeNode) tempParent.getParent();
		}
		if(newType == true) {
			Parent.add(tempNode);
			buildFamilies(textRest, tempNode);
		}
		
    }
    
    
	/*
    private void buildTree() {
		for (int i=0; i<children.size(); i++ )
		    buildTree(children.get(i), root); 
	    }
	*/
    // New method
    private void buildTree(treeNode node, treeNode parent) {  
		parent.add(node);
		if (!node.isLeaf()) {
		    for ( int i = 0; i < node.getChildCount(); i++ )
		    	buildTree((treeNode) node.getChildAt(i), node);            
		}        
    }
    
    public static void main(String [] args) {
    	new TreeOfLife();
    }
}

class treeNode extends DefaultMutableTreeNode{
	String type;
	String description;
	treeNode(){
		super();
	}
	treeNode(Object object) {
		super(object);
	}
	treeNode(Object object, boolean allCh){
		super(object, allCh);
	}
	treeNode(Object object, String theType){
		super(object);
		type=theType;
	}
	public String getType(){
		return type;
	}
	public void setDescription(String descr) {
		description = descr;
	}
}