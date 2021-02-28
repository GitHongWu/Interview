import java.util.*;

public class Main {

    // https://leetcode.com/problems/count-items-matching-a-rule/

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>(){{
            add(Arrays.asList(new String[]{"phone","blue","pixel"}));
            add(Arrays.asList(new String[]{"computer","silver","lenovo"}));
            add(Arrays.asList(new String[]{"phone","gold","iphone"}));
        }};

        String ruleKey = "color", ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleKeyIndex = 0;
        if(ruleKey.equals("color")){
            ruleKeyIndex = 1;
        }
        else if(ruleKey.equals("name")){
            ruleKeyIndex = 2;
        }
        
        int count = 0;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).get(ruleKeyIndex).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}