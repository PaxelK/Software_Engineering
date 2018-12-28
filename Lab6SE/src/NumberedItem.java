
public class NumberedItem <T> implements Comparable{
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
	public T getType(){return this.t;}
	public int getNum(T k){return this.num;}
	
	public String toString() {
		return("Index: " + this.t + "\t" + "Value: " +this.num);
	}

	@Override
	public int compareTo(Object o) {
		return(((int)this.t)-(int)((NumberedItem) o).getType());
	}

}
