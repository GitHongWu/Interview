using System;

namespace _1984._Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores
{
    class Program
    {
        // https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
        static void Main(string[] args)
        {
            int[] a = { 9, 4, 1, 7 };
            int k = 2;
            System.Console.WriteLine(MinimumDifference(a, k));
        }

        static public int MinimumDifference(int[] nums, int k) {
            Array.Sort(nums);
            int result = int.MaxValue;
            for (int i = 0; i <= nums.Length - k; i++)
            {
                int diff = nums[i + k - 1] - nums[i];
                if(diff < result) result = diff;
            }
            return result;
        }
    }
}
