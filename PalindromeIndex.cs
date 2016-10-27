using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HackerRank
{
    public class Program
    {
        /*
        aaab
        baa
        aaa
        */
        /*
            Check string is palindrome
            If palindrome return -1
            Iterate over string. Wherever equality fails, print index
            If center of string is reached, print -1     
        */

        // No. of bugs corrected: 2

        public static void Main(string[] args)
        {
            int cases = int.Parse(Console.ReadLine());

            //string[] arr = { "aaab", "baa", "aaa" };
            for (int i = 0; i < cases; i++)
            {

                Console.WriteLine(PrintOutput(Console.ReadLine()));
                //Console.WriteLine(PrintOutput(arr[i]));
            }

            //Console.ReadKey();
        }

        private static int PrintOutput(string str)
        {
            if (CheckPalindrome(str))
            {
                return -1;
            }

            int index = ProcessString(str);
            string newStr = str.Remove(index, 1);

            if (CheckPalindrome(newStr))
            {
                return index;
            }
            else
            {
                index = str.Length - 1 - index;
                newStr = str.Remove(index, 1);
                if (CheckPalindrome(newStr))
                {
                    return index;
                }
            }
            return -1;
        }

        private static bool CheckPalindrome(string str)
        {
            bool isPalindrome = false;
            int count = 0;
            while (count < str.Length / 2)
            {
                if (str[count] != str[str.Length - 1 - count])
                {
                    break;
                }
                count++;
            }

            if (count == str.Length / 2)
            {
                isPalindrome = true;
            }

            return isPalindrome;
        }

        private static int ProcessString(string str)
        {

            int count = 0;
            while (count < (str.Length - 1) / 2)
            {
                if (str[count] != str[str.Length - 1 - count])
                {
                    break;
                }
                count++;
            }

            return count;
        }
    }
}
