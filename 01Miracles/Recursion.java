public class Recursion implements hw1{
    

    public String name(){
	return "Yang,William";
    }

    public int fact(int n){
	//given number 100
	//100*99*98*97*96*95...and so on
	if(n < 0){
	    throw new IllegalArgumentException("Error: Cannot find the factorial of a negative number");
	}
	if(n == 0 || n == 1){
	    return 1;
	}
	return n * fact(n-1);
	//starting from 5
	//5 * fact(4) 
	//5 * 4 * fact(3)
	//5 * 4 * 3 * fact(2)
	//20 * fact(19) = 20 * 19 * fact(18) 
	
    }
    
    public int fib(int n){
	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
	//0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	//base case is still 0 
	if(n<0){
	    throw new IllegalArgumentException("Error: Cannot find fibonacci sequence given a negative index");
	}
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

    public double sqrt(double n){
	if(n<0){
	    throw new IllegalArgumentException("Error: Cannot find sqrt of a negative number");
	}
	return sqrt2(n, 1);
	//there's really no way to limit n so sending this to helper function
	//doesn't really matter where you start the guess 
    }


    public double sqrt2(double n, double guess){
	if(Math.abs(n/guess - guess) < .001){
	    // n = guess * guess
	    // n/guess = guess 
	    //since it's double instead of int, can't set it equal
	    //n/guess - guess < .001
	    return guess;
	}
	return sqrt2(n, (n/guess + guess)/2);
    }
}

