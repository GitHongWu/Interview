
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashSetTest {

    public static void main(String args[]) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);   //false
        System.out.println(s1.equals(s2));  //true
        System.out.println(s1.hashCode());  //96321
        System.out.println(s2.hashCode());  //96321

        // ������ΪString���Ѿ���д��equals()������hashcode()����������hashset��Ϊ��������ȵĶ��󣬽������ظ����        
        HashSet<String> hashset = new HashSet<String>();
        hashset.add(s1);
        hashset.add(s2);
        Iterator<String> it = hashset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // // HashMap����key
        // HashMap<String, String> h = new HashMap<String, String>();
        // h.put("a", "1");
        // h.put("a", "2");
        // Iterator hmIterator = h.entrySet().iterator(); 
        // while (hmIterator.hasNext()) { 
        //     Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        //     String marks = ((String)mapElement.getValue()); 
        //     System.out.println(mapElement.getKey() + " : " + marks); 
        // }
        // String s = h.get("a");
        // System.out.println(s);

    }
}