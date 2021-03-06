public class Main{

    public static void main(String []args){
        // 1******
        // 12*****
        // 123****
        // 1234***
        // 12345**
        // 123456*
        // 1234567
        int target = 14;
        myFunction(target);


        // Turn the String into a char[], replace the letter by index, then convert the array back into a String.
        String myName = "domanokz";
        char[] myNameChars = myName.toCharArray();
        myNameChars[4] = 'x';
        myName = String.valueOf(myNameChars);
    }
     
    public static void myFunction(int target){
        StringBuilder result = new StringBuilder("");
        for(int j = 0; j < target; j++){
            result.append('*');
        }
        
        for(int i = 0; i < target;i++){
            char c = (char)(i+1 + '0');
            result.setCharAt(i,c);
            System.out.println(result);
        }
    }
}