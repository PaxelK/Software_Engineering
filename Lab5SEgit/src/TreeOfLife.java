
import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.*;
import java.io.*;


public class TreeOfLife extends TreeFrame{

	
	ArrayList<treeNode> children;	//Old array used for builTree function. The newer one is builfFamilies()
	ArrayList<String> filelist;		//filelist is used to store all textlines from the read file.
	
    void initTree() {
	    boolean fileFound = false;
	    String fileName;
	    filelist = new ArrayList<String>();
	    /*
	     * A while loop is run until a file is found by entering its filename.
	     * The entire path to the file is added internally so one does not have
	     * to write the whole path..
	     */
	    while(fileFound == false) {
	    	Scanner userinput = new Scanner(System.in);
	    	System.out.println("Enter file name: ");
	    	fileName = userinput.nextLine().trim();
	       	fileName = "C:\\Users\\Axel Karlsson\\Documents\\GitHub\\Software_Engineering\\Lab5SEgit\\src\\" + fileName;
	       	System.out.println(fileName);
	       	try {
	    		 Scanner sc = new Scanner(new File(fileName));
	    		// Scanner sc = new Scanner(new File("/Users/Kaj/Documents/GitHub/Software_Engineering/Lab5SEgit/src/Life.txt"));
	    		 fileFound = true;
	    		 while (sc.hasNextLine()){
	    	    		String line = sc.nextLine();
	    	    		if (line.contains("\"")) {
				    		filelist.add(line);				// Only adds line that contains information.
			    		}
	    			}
	       	
	       	}
	   		catch (FileNotFoundException sc) {}
	   	}
	    
		root = new treeNode("Life", "World Tree");
		treeModel = new DefaultTreeModel( root );
	
		children = new ArrayList<treeNode>();
		tree = new JTree(treeModel);
	
	    	
	
	    	
	    	
	   	treeNode currentTopNode;
		String currentTop = "";
	   	String temp = "";
	    	
	   	buildFamilies(filelist, root);
	   	
		//buildTree();
    }

    /*
     * Our new recursive method. It runs each time by taking in who the parent of the new
     * node is and the remaining part of the text list. The method reads through the first
     * line of the list (then takes it away so the list gets shorter every time),
     * then it checks the node's name and type. Then the type is compared to the
     * parent's type and the parents above it.
     *  - 	If there is no such type above, this must mean it is a leaf. 
     *  -	If there exists such a type in any of the above layers. That type's
     *  	parent is put as the new node's parent too.
     */
    private void buildFamilies(ArrayList<String> textRest, treeNode Parent) {  	
    	
    	/*
    	 * If the list is empty the function will just return before doing anything.
    	 */
    	if(textRest.isEmpty()) {
    		return;
    	}
    	String line = textRest.get(0);	//Get next line and save it to a var
    	textRest.remove(0);				//Remove it
    	
    	Boolean newType = true;			//Flag for checking if the type is new or if it's a higher layer.
    	
    	//GETS THE HIERARCHY TYPE
    	String[] typeArr = line.split("\\s", 2);
		String type = typeArr[0].replaceFirst("<", "");
		
		//Takes the NAME which is enveloped by "" and creates a node with it.
		String nodeName = "";
		String nodeDescr = "";
		if(line.contains("\"")){
			String[] infoArr = line.split("\"");
			nodeName = infoArr[1];
			
			//Takes the description
			nodeDescr = infoArr[2];
			nodeDescr = nodeDescr.substring(1,nodeDescr.length());
			//System.out.println(nodeDescr);
			
		}
		
		treeNode tempNode = new treeNode(nodeName, type, nodeDescr);
		/*
		 * After a node has been created. The method decides where it will be
		 * placed.
		 */
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
     * Old method that isnt used anymore. It has been replaced with 
     * buildFamilies()
     */
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

/*
 * The new extension of DefMutTreeNode.
 * It now has variables storing it's type and description. With corresponding
 * functions to be able to access them.
 */
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
	treeNode(Object object, String theType, String descrip){
		super(object);
		type=theType;
		description = descrip;
	}
	public String getType(){
		return type;
	}
	public void setDescription(String descr) {
		description = descr;
	}
	public String getDescription() {
		return description;
	}
}