
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
	public int getNum(){return this.num;}
	
	public String toString() {
		return("Index: " + this.t + "\t" + "Value: " +this.num);
	}

	
	// How are we supposed to do? Since the type can't be casted as an integer. How are we going to change it to it. 
	public int compareTo(Object o) {
		if (this.t instanceof Integer && ((NumberedItem) o).getType() instanceof Integer) {
			
			if(((int)this.t < 0) &&(((int)((NumberedItem) o).getType() < 0))){
				return 0;
			}
				
			else if((int)this.t < 0) {
				return(0-(int)((NumberedItem) o).getType());
			}
			else if ((int)((NumberedItem) o).getType() < 0){
				return(((int)this.t)-0);}

			
			else {
				return(((int)this.t)-(int)((NumberedItem) o).getType());
			}
		}
		else { 
			return(this.num-((NumberedItem) o).getNum());
		}

		}
	

}
