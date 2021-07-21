using System;

namespace _704._Binary_Search
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = new int[]{1, 4, 6, 8};
            int target = 2;
            System.Console.WriteLine(binarySearch2(array, target));
        }

        // 找到准确tar的index
        public static int binarySearch(int[] arr, int tar){
            int left = 0;
            int right = arr.Length - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (arr[mid] == tar) return mid;
                else if (arr[mid] < tar) left = mid+1;
                else right = mid - 1;
            }
            return -1;
        }

        // 最接近tar的left作为index
        public static int binarySearch2(int[] arr, int tar){
            int left = 0;
            int right = arr.Length-1;
            while (left+1 < right){    // 左右两边的数距离target一样远时(例如25 35，target是30)，我们需要二分搜索出左边那位，就要while(left+1 < right)来提前一次终止循环，使left落在25，同时left = mid，不能=mid+1防止left错过mid数。
                int mid = left + (right - left) / 2;
                if (arr[mid] == tar) return mid;
                else if (arr[mid] < tar) left = mid;
                else right = mid;
            }
            return left;
        }
    }
}
