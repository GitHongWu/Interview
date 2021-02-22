import java.util.*;

public class Main {

    public static void main(String[] args) {
        // class name call static method
        MyStatic.print();
        // even = null, static method works still
        MyStatic m = null;
        m.print();
    }
}

class MyStatic {
    public static void print(){
        System.out.println("print static successful !");
    }
}