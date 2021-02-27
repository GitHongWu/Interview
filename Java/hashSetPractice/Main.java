import java.io.*;
import java.util.*;

class Main {
    // input  output
    // 3       UIJ
    // 3       UUH
    // 4      ERKJ
    // A-Z, unique, random
  
	public static void main (String[] args) {
        int inputNum = 2;
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < 55; i++){
            myFunction(inputNum, set);
        }
        System.out.println("set size: " + set.size());
	}
  
    public static void myFunction(int inputNum, HashSet<String> set){
        Random rand = new Random();
        int min = 65;  // A
        int max = 90;  // Z
        String result = "";
        set.add(result);
        while(set.contains(result) && set.size() < 26 * inputNum + 1){  // size<27 include initialized value: ""
            result = "";
            for (int i = 0; i < inputNum; i++){
                int random_int = (int)(Math.random() * (max - min + 1) + min);
                char c = (char)random_int;
                result += c;
            }
        }
        set.add(result);
        System.out.println(result);
    }
}
