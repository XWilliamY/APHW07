import java.util.*;

public class QuickSelect{

    public int quickselect(int[] ary, int n){
	return quickselect(ary, 0, ary.length-1, n-1);
    }

    public int quickselect(int[]ary, int start, int end, int n){
	if(start <= end){
	    int pivot = partition(ary, start, end);
	    if(pivot == n){
		return ary[n];
	    }
	    if(pivot > n){
		return quickselect(ary, start, pivot - 1, n);
	    }
	    return quickselect(ary, pivot + 1, end, n);
	}
	return Integer.MIN_VALUE;
    }

    public int partition(int[]ary, int start, int end){
	int pivot = start + new Random().nextInt(end - start + 1);
	swap(ary, end, pivot);
	for(int i = start; i < end; i++){
	    if(ary[i] > ary[end]){
		swap(ary, i, start);
		start++;
	    }
	}
	swap(ary, start, end);
	return start;
    }

    private void swap(int[]ary, int orig, int newer){
	int temp = ary[orig];
	ary[orig] = ary[newer];
	ary[newer] = temp;
    }

    public QuickSelect(){
	int [] A = new int [10];
	for(int i = 0; i < A.length;i++){
	    A[i] = 10-i;
	}
	System.out.println(Arrays.toString(A));
	System.out.println(quickselect(A, 2));
	System.out.println(Arrays.toString(A));
    }

    public static void main(String[]args){
	QuickSelect A = new QuickSelect();
    }

}