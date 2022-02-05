using System;
using System.Collections.Generic;
using System.Linq;

namespace ArrayPractice
{
    class Program
    {
        // declare array
        //      double[] balance = new double[10];
        //      double[] balance = { 2340.0, 4523.69, 3421.0};
        //      int [] marks = new int[5]  { 99,  98, 92, 97, 95};
        //      int [] marks = new int[]  { 99,  98, 92, 97, 95};

        // Multidimensional Arrays
        // four rows and two columns
        //      int[, ] intarray = new int[4, 2];
        // creates an array of three dimensions, 4, 2, and 3
        //      int[,, ] intarray1 = new int[4, 2, 3];

        static void Main(string[] args)
        {
            int[] arr1 = new int[] { 0, 1, 2, 3, 4, 5 };
            int[] arr2 = { 5, 10, 20, 30, 40, 50 };
            
            // display array
            Console.WriteLine(String.Join(",", arr1));
            // Array.ForEach(arr2, Console.WriteLine);
            Array.ForEach(arr2,  val => Console.Write("{0} ", val));


            // convert to list then print
            int[] array = { 1, 2, 3, 4, 5 };
            List<int> nums = array.ToList();
            nums.ForEach(Console.WriteLine);
        }
    }

    // array.Length
    // array.Rank
}
