
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
	
	/*
	 * TWO NEW CLASSES HAS BEEN DEFINED, one abstract and another one extending it, to take care of the int value and casting it is a type <T>
	 * SEE MathValue and OperandValue
	 */
	public void setType(T k){
		this.t = k;
		if (this.t instanceof Integer) {
			if(((int)this.t < 0)) {
				OperandValue temp = new OperandValue(0);
				this.t= (T) temp.value;
			}
		}

		}

	public T getType(){return this.t;}
	public int getNum(){return this.num;}
	
	public String toString() {
		return("Index: " + this.t + "\t" + "Value: " +this.num);
	}

	/*
	 * if the type argument is of type integer, we subtract the values of their index value.
	 * Otherwise we subtract the values of the num-values
	 */
	public int compareTo(Object o) {
		if (this.t instanceof Integer && ((NumberedItem) o).getType() instanceof Integer) {
			return(((int)this.t)-(int)((NumberedItem) o).getType());
		}
		else { 
			return(this.num-((NumberedItem) o).getNum());
		}

	}
	/*
	 * NOT SURE IF THIS IS CHEATING. Before this, the equal method would not see instances of this class as equal even though they were
	 * both instances of the same class and had the same types and values of their parameters. The equals()-function would not work with comparing
	 * integers, so the equals()-function had to be overridden to check class type, then check if type equals type and int-val == int-val.
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean temp = false;
		if(obj instanceof NumberedItem) {
			if(((NumberedItem)obj).getType().equals(getType()) && ((NumberedItem)obj).getNum()==getNum()) {
				return true;
			}
		}
		
		return temp;
	}
	/*
	 * The abstract class math value. It takes in a type T and stores it in value. Honestly no idea what isOperand and isOperator is meant to do..
	 */
	abstract class MathValue<T> {
        final T value;

        MathValue(T value) {
                this.value = value;
        }

        abstract boolean isOperator();

        boolean isOperand() {
                return !isOperator();
        }
	}
	/*
	 * Extends the abstract class math-value and takes in an int which it then passes onto the constructor via _super_ which stores it in <T> value.
	 */
	class OperandValue extends MathValue<Integer> {

        OperandValue(int operand) {
                super(new Integer(operand));
        }

        @Override
        public boolean isOperator() {
                return false;
        }
}
	/*
	 * Just a bunch of testing done to see how everything works.
	 */
	public static void main(String[] args) {
		NumberedItem<Integer> i1 = new NumberedItem<>(-1,1);
		NumberedItem<Integer> i2 = new NumberedItem<>(0,1);
		NumberedItem<Integer> i3 = new NumberedItem<>(7,117);
	    
	    System.out.println(i1.getType());
	    System.out.println(i2.getType());
	    System.out.println(i3.getType());
	    
	    System.out.println(i1.equals(i2));
	    
	    System.out.println(i1.getType().equals(i2.getType()));
	   // System.out.println(i1.getNum().equals(i2.getNum()));
	    
	    System.out.println(i1);
	    System.out.println(i2);
	    
	    System.out.println(i1.getType().getClass());
	    System.out.println(i2.getType().getClass());
	}
}
