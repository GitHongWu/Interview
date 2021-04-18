import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        
        // if((0&1)==0) System.out.println("t");

        // string2Bits();   // any string convert to binary
        // int2String();  // convert int to bits in string format with 8 digits
        // int2Bits2();  // convert int to bits with fix size

        N_bits(2);   // generate all possible bits of length N
    }

    static void N_bits(int n){
        int max = (int)Math.pow(2, n);
        // System.out.println(max);
        for (int i = 0; i < max; i++){
            System.out.println(int2Bits2(i));
        }
    }

    static String int2Bits2(int my_integer){
        // int my_integer = 8;
        String cBinaryString=Integer.toBinaryString(my_integer);
        // System.out.println(cBinaryString);
        return cBinaryString;
    }

    static String int2String(){
        int my_integer = 8;
        String a = String.format("%08d", Integer.valueOf(Integer.toBinaryString(my_integer)));
        System.out.println(a);
        return a;
    }

    static void string2Bits(){
        String text = "Hello, World!";
        System.out.println("Text: "+text);

        String binary = new BigInteger(text.getBytes()).toString(2);
        System.out.println("As binary: "+binary);

        String text2 = new String(new BigInteger(binary, 2).toByteArray());
        System.out.println("As text: "+text2);
    }
}