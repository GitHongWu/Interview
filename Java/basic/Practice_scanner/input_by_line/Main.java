import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{	
	public static void main(String args[])
	{
	    //INPUT[uncomment & modify if required]
        // input example 1
        // 1
        // 0 4
        // example 2
        // 2
        // 0 5
        // 0 1
	    
		Scanner sn=new Scanner(System.in);
		
		int N;
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		int[] S=new int[N];
		int[] R=new int[N];
		
		
		for(int i=0;i<N;i++)
		{
            S[i] = sc.nextInt();
            R[i] = sc.nextInt();
		}
		
		//OUTPUT[uncomment & modify if required]
		System.out.println(N);
		System.out.println(Arrays.toString(S));
		System.out.println(Arrays.toString(R));
	}
	
}