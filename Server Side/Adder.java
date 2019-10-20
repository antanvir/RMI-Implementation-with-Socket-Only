

import java.io.Serializable;

public class Adder implements Serializable {
    private static final long serialVersionUID = -5399605122490343339L;

    private int A;
    private int B;
    private int result; 

    public Adder() {
    	
    }
    

    public Adder(int firstNumber, int secondNumber ){
        this.A = firstNumber; 
        this.B = secondNumber;
    }
    
    public int add(int a, int b){
    	result = a + b;
//    	System.out.println("Sum is: " + result);
    	return result;
    }
    
    public int add(){
        result = A + B;
//        System.out.println("Sum is: " + result);
        return result;
    }
    
    public int getA() {
    	return A;
    }
    
    public int getB() {
    	return B;
    }
    
    public int getResult() {
    	return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Adder().add(5, 7));
    }

}