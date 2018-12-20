
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class textTest {

	public static void main(String[] args) {
    	ArrayList<String> filelist = new ArrayList<String>();

    	try {
			 Scanner sc = new Scanner(new File("C:\\Users\\Axel Karlsson\\eclipse-workspace\\Lab5SE\\src\\Lab5package\\Life.txt"));
				while (sc.hasNextLine()){
		    		String line = sc.nextLine();
		    		filelist.add(line);
				}
    	
    	}
		catch (FileNotFoundException sc) {}
		
    	String temp = "";
    	for(String line: filelist) {
    		String[] type = line.split("\\s");
    		type[0] = type[0].replaceFirst("<", "");
    		if(type[0].equals("Rike")) {
    			line = "\t" + line;
    		}
    		if(line.contains("\"")){
    			String[] Name = line.split("\"");
        		if(Name[1].equals("Liv")) {
        			System.out.println("HEJ!!!!");
        		}
    		}
    		
    		
    		System.out.println(line);
    	}
    	
	}
}
