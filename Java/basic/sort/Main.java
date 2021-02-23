import java.util.Arrays; 
import java.util.Collections;
import java.util.ArrayList;
 
public class Main
{
    public static void main(String[] args){
        // sort1();    //sort using Arrays
        // sort2();    //sort using Collections
        sort3();    //sort sub-array using Arrays
        // sort4();    //Arrays lambda
    }

    public static void sort4(){
        // sort by absolute  value
        Integer[] array = {9,-2,10,3,-5,34,-22,7};
        Arrays.sort(array, (a,b) -> (Integer.compare( Math.abs(a),  Math.abs(b))));
        System.out.println(Arrays.toString(array));

        // Lambda sort in ascending order
        Integer[] arr = new Integer[]{13, 7, 6, 45, 21, 9, 101, 102};
        Arrays.sort(arr, (a,b) -> a-b);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort1(){
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        Arrays.sort(arr);
        System.out.printf("Modified arr[] : %s\n",
                          Arrays.toString(arr));

        // sort in descending order 
        Integer[] arr2 = { 13, 7, 6, 45, 21, 9, 2, 100 };
        Arrays.sort(arr2, Collections.reverseOrder()); 
  
        System.out.printf("Modified arr[] : %s\n", 
                          Arrays.toString(arr2)); 
    }

    // sort arraylist or linklist
    public static void sort2(){
        // Create a list of strings 
        ArrayList<String> al = new ArrayList<String>(); 
        al.add("Geeks For Geeks"); 
        al.add("Friends"); 
        al.add("Dear"); 
        al.add("Is"); 
        al.add("Superb"); 
  
        // in ascending order
        Collections.sort(al);
        System.out.println(al);

        // in descending order
        Collections.sort(al, Collections.reverseOrder());
        System.out.println(al); 
    }

    // sort sub-array
    public static void sort3(){
        int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 }; 
        Arrays.sort(arr, 1, 5); // [13, 6, 7, 21, 45, 9, 2, 100]
        System.out.printf("Modified sub arr[] : %s", 
                          Arrays.toString(arr));
    }
}