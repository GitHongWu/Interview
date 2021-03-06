import java.util.*;

public class Main {
    // 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组
    // 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
    // 解集中不能包含重复的三元组。
    // input: {-10 0 10 20 -10 -40}
    // output: (-10, 0, 10) (-10, -10, 20)

    public static void main(String[] args) {
        int target = 0;
        int[] array = new int[]{-10, 0, 10, 20, -10, -40};
        int[] array2 = new int[]{-1,0,1,2,-1,-4};

        sum2tar(array2, target);

        for(ArrayList<Integer> list: threeSum(array2)){
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
    }

    // 自定义target的三元组
    // 解题思路：先把arr进行排序，对arr里的每一个元素arr[i]进行target-arr[i]运算得到second_tar。这时候问题就变成了找
    // 对应second_tar的二元组了。找二元组用双指针从头尾遍历，遍历时确保不包括当前元素arr[i],并用hashset保证答案不重复
    public static void sum2tar(int[] arr, int target){
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        HashSet<String> set = new HashSet<>();  // use for remove duplicate
        for(int i = 0; i < arr.length; i++){
            int second_tar = target-arr[i];   // second_tar is the target number minus each int in array
            int left = 0, right = arr.length-1; // declare two pointer, approch to the target number
            while(left < right){
                int sum = arr[right] + arr[left];
                if(sum == second_tar && i!=right && i!=left) {  // i不被重复计算
                    int result_index[] = new int[]{arr[i], arr[left], arr[right]};  //将符合的答案存入并sort
                    Arrays.sort(result_index);
                    if (!set.contains(Arrays.toString(result_index))){
                        System.out.println("(" + arr[i] + ", " + arr[left] + ", " + arr[right] + ")");
                        set.add(Arrays.toString(result_index)); // store into set
                    }
                    left++;
                    right--;
                }
                else if (sum < second_tar) left++;
                else right--;
            }
        }
    }

    // 和为0的三元组
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = num.length;
        if(n < 3) return result;
        // 排序
        Arrays.sort(num);
        for (int i = 0; i < n-2; i++){
            int left = i+1;
            int right = n-1;
            int target = 0 - num[i];
            if(i!=0 && num[i] == num[i-1]) continue;    //去重
            while(left < right){
                int sum = num[left] + num[right];
                if(sum < target) left++;
                else if(sum > target) right--;
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    result.add(temp);
                    while (left + 1 < right && num[left+1] == num[left]) ++left;  // 防止重复
                    while (right - 1 > left && num[right-1] == num[right]) --right;  // 防止重复
                    ++left; --right;
                }
            }
        }
        return result;
    }
}