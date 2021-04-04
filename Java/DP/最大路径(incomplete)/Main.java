import java.lang.*;
import java.io.*;
import java.util.*;
 
public class Main
{   

    // 最大路径问题，只能向下或是下左走，求最大路径的和
    // input:
    // 4
    // 1
    // 1 2
    // 4 1 2
    // 1 3 2 1
    // output: 9
    // 1 -> 1 -> 4 -> 3 = 9
    // https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
    public static void main(String[] args)
    {
        // INPUT [uncomment & modify if required]
        Scanner sc=new Scanner(System.in);
 
        int N = sc.nextInt();
        int k=1;
        int A[][]= new int [1000][1000];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<k;j++){
                A[i][j]=sc.nextInt();
            }   
            k++;
        }    
 
        //OUTPUT [uncomment & modify if required]
        System.out.println(sumLargest(N,A));
    
    }

    public static int sumLargest(int N, int[][] A){
        
        //this is default OUTPUT. You can change it.
        int result=0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= A[i].length; j++){
                if(i == 0 && j==0) continue;
                else if(i == 0) A[i][j] = A[i][j] + A[i][j-1];
                else if(j-1 != 0 && i-1!=0) A[i][j] = A[i][j] + A[i-1][j-1];
                else A[i][j] = Math.max(A[i-1][j-1], A[i][j-1])+A[i][j];
            }
            return A[A.length-1][A[0].length-1];
        }    
        return result;
    }
}