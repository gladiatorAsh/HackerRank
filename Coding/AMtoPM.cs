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
        07:05:45PM
        19:05:45
        */

        // No. of compiles: 8
        // No. of bugs corrected: 6

        public static void Main(string[] args)
        {
            string time = Console.ReadLine();
            int HALF_DAY = 12;
            string[] arr_time = time.Split(':');
            int hour = int.Parse(arr_time[0]);

            if (time.Contains("PM"))
            {
                if (hour != 12)
                {
                    hour = hour + HALF_DAY;
                    arr_time[0] = "";
                    string newTime = string.Join(":", arr_time);
                    time = string.Join("", hour, newTime);
                }

                time = time.Replace("PM", "");
            }
            else
            {
                if (hour == 12)
                {
                    arr_time[0] = "00";
                    string newTime = string.Join(":", arr_time);
                    time = string.Join("", newTime);
                }

                time = time.Replace("AM", "");
            }
            Console.WriteLine(time);
            Console.ReadKey();
        }
    }
}
