import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // String input = in.nextLine();
        // String[] s = [input.split(",")];
        String s[] = { "1", "3", "2", "4", "5" };
        
        System.out.println(countSwap(s));
    }
    
    public static int countSwap(String[] s){
        if(s.length <= 1){
            return 0;
        }
        
        int count = 0;
        for(int i = 1; i < s.length; i++){
            int j = i;
            while(Integer.parseInt(s[j]) < Integer.parseInt(s[j-1])){
                String temp = s[j];
                s[j] = s[j-1];
                s[j-1] = temp;
                count++;
                j--;
                if(j == 0){
                    break;
                }
            }
        }
        return count;
    }
}