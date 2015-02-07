public class Recursion implements hw1{
    public static void main(String[]args){
	System.out.println(fact(19));
	System.out.println(fib(2));
	System.out.println(sqrt(4));
    }

    public String name(){
	return "Yang,William";
    }

    public static int fact(int n){
	//given number 100
	//100*99*98*97*96*95...and so on
	if(n == 1){
	    return n;
	}
	return n * fact(n-1);
	//starting from 5
	//5 * fact(4) 
	//5 * 4 * fact(3)
	//5 * 4 * 3 * fact(2)
	//20 * fact(19) = 20 * 19 * fact(18) 
	
    }
    
    public static int fib(int n){
	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
	//0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	//base case is still 0 
	if(n == 0 || n == 1){
	    return n;
	}
	//base case is either 0 or 1
	return fib(n-1) + fib(n-2);
	//fib(5)= 
	//fib(4) + fib(3) = 
	//(fib(3)+fib(2)) + (fib(2)+fib(1))
	//((fib(2)+fib(1)) + (fib(1)+fib(0)) + (fib(1)+fib(0) + fib(1))
	//((fib(1)+fib(0)) + 1) + (1 + 0 + (1 + 0 + 1))
	//(1 + 0 + 1) + (1 + 0 + 1 + 0 + 1)
	//1 + 1 + 1 + 1 + 1 = 5 
    }

    public static double sqrt(double n){
	return sqrt2(n, 1);
    }


    public static double sqrt2(double n, double guess){
	if((guess*guess)/n <= .01){
	    return guess;
	}
	return sqrt2(n, (n/guess + guess)/2);
    }
}

