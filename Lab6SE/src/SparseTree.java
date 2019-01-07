import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;



public class SparseTree <K extends Integer,V> extends TreeMap<Integer,V> implements SparseVector<V>{

	
	public void add(V v) {	
		if (this.firstEntry()==null || this.firstKey()==1 ) {
			add(0,v);
		}
		else{
			add((this.firstKey()-1),v);
		}
	}

	public void add(int pos, V v) {this.put(pos, v);}

	public V get(int pos) {return this.get(pos);}
	
	public int indexOf(V v){
		for (Integer key: this.keySet()) {
			if(this.get(key).equals(v) || this.get(key) == v){
				return (int)key;
			}
		}
		return -1;
	}

	public void removeAt(int pos) {this.remove(pos);}

	public void removeElem(V v) {
		int tempKey = -1;
		for (Integer key: this.keySet()) {
				if(this.get(key).equals(v) || this.get(key) == v){
					tempKey = (int) key;
					break;
				}
		}
		if (tempKey!=-1) {
			this.remove(tempKey);	
		}
	}

	public int size() {return this.size();}

	public int minIndex() {
		if (this.firstEntry()!=null) {
			return (int) this.firstKey();
		}
		else {
			return -1;
		}
	}
	
	public int maxIndex() {
		if (this.firstEntry()!=null) {
			return (int) this.lastKey();
		}
		else {
			return -1;
		}
	}
	public String toString() {
        StringBuilder builder = new StringBuilder();
		for (Integer key: this.keySet()) {
			builder.append("Element: ").append(key).append("\t").append("Value: ").append(this.get(key)).append("\n");
		}
		return builder.toString();
         
   	}

	
	public static void main(String[] args) {
		Sparse<Integer> sparse = new Sparse<Integer>();
		System.out.println(sparse.minIndex());
		System.out.println(sparse.maxIndex());

		sparse.add(10, 1);
		sparse.add(1, 2);
		sparse.add(5, 3);
		
		System.out.println(sparse.minIndex());
		System.out.println(sparse.maxIndex());
	
		System.out.println(sparse.indexOf(1));
		sparse.removeElem(3);
		System.out.println(sparse.get(10));
		System.out.println(sparse.size());
		sparse.add(5, 5);
		sparse.add(5, 5);

		System.out.println(sparse.get(5));

		System.out.println(sparse.size());
		
		Sparse<String> sparse2 = new Sparse<String>();
		System.out.println(sparse2.minIndex());
		System.out.println(sparse2.maxIndex());

		sparse2.add(10, "a");
		sparse2.add(1, "b");
		sparse2.add(5, "c");
		
		System.out.println(sparse2.minIndex());
		System.out.println(sparse2.maxIndex());
	
		System.out.println(sparse2.indexOf("a"));
		sparse2.removeElem("c");
		System.out.println(sparse2.get(10));
		System.out.println(sparse2.size());
		sparse2.add(5, "hej");
		sparse2.add(5, "kalle");

		System.out.println(sparse2.get(5));

		System.out.println(sparse2.size());
		System.out.println(sparse);
		System.out.println(sparse2);

		



	}







}
