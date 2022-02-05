using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _01
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = new Dictionary<string, string>();
            a.Add("a", "a");
            a.Remove("s");
            System.Console.WriteLine(a.Count);
        }
    }
}