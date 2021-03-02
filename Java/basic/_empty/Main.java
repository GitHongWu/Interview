import java.lang.*;
import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add(Arrays.toString(new int[]{0,1,2}));
        System.out.println(set.contains(Arrays.toString(new int[]{0,1,2})));
        Arrays.sort()
        System.out.println(set.contains(Arrays.toString(new int[]{0,1,2})));
    }
}