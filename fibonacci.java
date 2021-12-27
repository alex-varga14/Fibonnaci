import java.util.Scanner;
/**
 * @author Alexander Varga
 * @date 9th of July 2021
 * @version 1.1
 */
public class fibonacci 
{
	//cache designated for fibMem()
	public static int[] cache = new int[10000];
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a Nth Fibonacci Number to be calculated: ");
		int num = input.nextInt();
		//StringBuilder a = new StringBuilder();
		//StringBuilder b = new StringBuilder();
		//StringBuilder c = new StringBuilder();
		for(int i = 0; i < num; i++) {
			int fR = 0, fM = 0, fI = 0;
			
			//fibRec Algorithm Timing Test
			long sTime = System.nanoTime();
			fR = fibRec(i);
			long fibRecTimeElapsed = System.nanoTime() - sTime;
			System.out.println("Time to compute f(" + (i+1)+")" + " = " + fR + " using Algorithm 1 is " + fibRecTimeElapsed);
			//a.append(fibRecTimeElapsed + "\n");
			
			//fibMem Algorithm Timing Test
			sTime = System.nanoTime();
			fM = fibMem(i);
			long fibMemTimeElapsed = System.nanoTime() - sTime;
			System.out.println("Time to compute f(" + (i+1)+")" + " = " + fM + " using Algorithm 2 is " + fibMemTimeElapsed);
			//b.append(fibMemTimeElapsed + "\n");
			
			//fibIter Algorithm Timing Test
			sTime = System.nanoTime();
			fI = fibIter(i);
			long fibIterTimeElapsed = System.nanoTime() - sTime;
			System.out.println("Time to compute f(" + (i+1)+")" + " = " + fI + " using Algorithm 3 is " + fibIterTimeElapsed);
			//c.append(fibIterTimeElapsed + "\n");
		}
		input.close();
		//System.out.println("Here is Recursive time: \n" + a.toString());
		//System.out.println("Here is Mem time: \n" + b.toString());
		//System.out.println("Here is Iter time: \n" + a.toString());
	}

	//Recursive fibonacci funtion
	private static int fibRec(int n) 
	{
		if (n <= 1)
			return n;
		else 
			return fibRec(n-1)+ fibRec(n-2); 
	}
	
	//Memorization fibonacci function
	public static int fibMem(int n) 
	{
		if (n <= 1) 
			return n;
		if(cache[n] != 0) {
			return cache[n];
		} else {
			cache[n] = fibMem(n-2)+fibMem(n-1);
			return cache[n];
		}
	}
	
	//iterative fibonacci function
	private static int fibIter(int n) 
	{
		int previous = 0, preceding = 1, future = 0;
		if (n <= 1) {
			if(n < 1)
				return previous;
			return preceding;
		} else {
			for(int i = 0; i < n-1; i++) {
				future = previous + preceding;
				previous = preceding;
				preceding = future;
			}
			return future;
		}
	}
}
