
public class NumberedItem <T> extends Comparable{
	private T t;
	private int num;
	NumberedItem(T k, int number){
		setType(k);
		setNum(number);
	}
	
	public void setNum(int Num){
		if(Num < 0) {
			this.num = 0;
		}
		else {
			this.num = Num;
		}
	}
	public void setType(T k){this.t = k;}
	public void getType(T k){return this.t;}
	public void getNum(T k){return this.num;}
	
	public void compareTo(NumberedItem t2) {
			return(this.T-t2.getType());
	}
	
	public String toString() {
		return("Index: " + this.t + "\t" + "Value: " +this.num);
	}

}
