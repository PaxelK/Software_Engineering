
public class NumberedItem <T> extends Comparable{
	private T t;
	private int num;
	NumberedItem(T k, int number){
		setType(k);
		setNum(number);
	}
	public void setType(T k){
		this.t = k;
	}
	public void setNum(int Num){
		if(Num < 0) {
			this.num = 0;
		}
		else {
			this.num = Num;
		}
	}
	
	public void compareTo(NumberedItem t2) {
		if(this.num < t2.) {
			
		}
	}
	
	public String toString() {
		return("Index: " + this.t + "\t" + "Value: " +this.num);
	}

	
	public static void main(String[] args) {
		
	}

}
