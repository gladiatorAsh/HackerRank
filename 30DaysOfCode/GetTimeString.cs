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
        5:00 five o clock 
        5:01 one minute past five
        5:10 ten minutes past five
        5:30 half past five
        5:40 twenty minutes to 6
        5:45 quarter to six
        5:47 thirteen minutes to six
        5:28 twenty eight minutes past five             
        */

        // No. of compiles: 6
        // No. of bugs corrected: 2

        public static void Main(string[] args)
        {
            int TOTAL_MINUTES = 60;
            int HALF_TIME = 30;

        start:

            Console.WriteLine("Hello World!");

            int hour = int.Parse(Console.ReadLine().ToString());
            int minutes = int.Parse(Console.ReadLine().ToString());
            string output = string.Empty;
            bool isGreaterThanHalf = false;

            if (minutes > HALF_TIME)
            {
                isGreaterThanHalf = true;
                minutes = TOTAL_MINUTES - minutes;
            }

            output = Process(hour, minutes, isGreaterThanHalf);

            Console.WriteLine(output);

            Console.ReadKey();

            goto start;
        }

        private static string Process(int hour, int minutes, bool isGreaterThanHalf)
        {
            string output = string.Empty;

            Dictionary<int, string> numerals = new Dictionary<int, string>()
            {
                { 1,"one" },
                { 2,"two" },
                { 3,"three" },
                { 4,"four" },
                { 5,"five" },
                { 6,"six" },
                { 7,"seven" },
                { 8,"eight" },
                { 9,"nine" },
                { 10,"ten" },
                { 11,"eleven" },
                { 12,"twelve" },
                { 13,"thirteen" },
                { 14,"fourteen" },
                { 15,"quarter" },
                { 16,"sixteen" },
                { 17,"seventeen" },
                { 18,"eighteen" },
                { 19,"nineteen" },
                { 20,"twenty" },
                { 21,"twenty one" },
                { 22,"twenty two" },
                { 23,"twenty three" },
                { 24,"twenty four" },
                { 25,"twenty five" },
                { 26,"twenty six" },
                { 27,"twenty seven" },
                { 28,"twenty eight" },
                { 29,"twenty nine" }
            };

            if (numerals.ContainsKey(hour))
            {
                //5:00
                if (minutes == 0)
                {
                    output = numerals[hour] + " o' clock";
                    return output;
                }
                //5:30
                else if (minutes == 30)
                {
                    output = "half past " + numerals[hour];
                    return output;
                }
                //5:45
                else if (isGreaterThanHalf && minutes == 15)
                {
                    output = "quarter to " + numerals[hour + 1];
                    return output;
                }
                //5:15
                else if (!isGreaterThanHalf && minutes == 15)
                {
                    output = "quarter past " + numerals[hour];
                    return output;
                }

                if (isGreaterThanHalf && numerals.ContainsKey(minutes))
                {
                    output = numerals[minutes] + " minutes to " + numerals[hour + 1];
                    return output;
                }
                //5:01
                else if (minutes == 1)
                {
                    output = numerals[minutes] + " minute past " + numerals[hour];
                    return output;
                }
                else
                {
                    output = numerals[minutes] + " minutes past " + numerals[hour];
                    return output;
                }
            }

            //If  no match
            output = "Error";

            return output;
        }
    }
}
