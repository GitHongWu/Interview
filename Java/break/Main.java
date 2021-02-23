import java.util.*;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if(j == 2) break;   // break Ö»breakµ±Ç°loop
                System.out.print(j + " ");
            }
            System.out.println(i);
        }
    }
}