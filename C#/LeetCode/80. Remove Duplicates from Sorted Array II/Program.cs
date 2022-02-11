using System;

namespace _80._Remove_Duplicates_from_Sorted_Array_II
{
    class Program
    {
        // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
        static void Main(string[] args)
        {
            int[] a = { 1, 1, 1, 2, 2, 3 };
            System.Console.WriteLine( RemoveDuplicates(a) );
            RemoveDuplicates(a);
        }

        static public int RemoveDuplicates(int[] nums)
        {
            if (nums.Length <= 2) return nums.Length;

            int slow = 2, fast = 2;
            // System.Console.WriteLine(slow + " ");
            for (int i = 2; i < nums.Length; i++)
            {
                if (nums[slow - 2] != nums[fast])
                {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
