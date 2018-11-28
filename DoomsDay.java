import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

/*
  Implementation of the doomsday algorithm to find any day of the year from 1000-2300
*/
public class Solution {
    public static void main(String args[]) throws Exception {

        String[] dayweek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(10, 5);
        map.put(11, 3);
        map.put(12, 2);
        map.put(13, 0);
        map.put(14, 5);
        map.put(15, 3);
        map.put(16, 2);
        map.put(17, 0);
        map.put(18, 5);
        map.put(19, 3);
        map.put(20, 2);
        map.put(21, 0);
        map.put(22, 5);
        map.put(23, 3);

        /*
         * a= Find doomsday in numeric 0-6 b= Divide the last two digits by 12 and take
         * quotient c= Let c be the remainder of b/4 d= the sum of a+b+c e= d%7
         * 
         * Count forward these many days from the nearest doomday
         * 
         * 11/27/2018 => Tuesday 2 a=1 b=6 c=1 d=8 e= 8%7=1
         * 
         * Tuesday+1= Wednesday 12/12/2018 12/12 4/4 8/8 fall on this day 11/27 is 15
         * days from 12/12/ Hence day is 1 off from Wednesday ie Tuesday
         * 
         * 11/27/1952 Wednesday a= 4 b= 4 c= 1 d= 9 e = 2
         * 
         * Wed+2=> Friday 12/12 4/4 8/8 fall on this day
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Enter day");
        int day = input.nextInt();
        System.out.println("Enter month");
        int month = input.nextInt();
        System.out.println("Enter year");
        int year = input.nextInt();

        System.out.println(month + " " + day + " " + year);
        input.nextLine();

        if (day > 31 || month > 12 || year < 1000 || year > 2300) {
            throw new Exception("Error in input");
        }

        int index = map.get(year / 100);

        int a = (year % 1000) / 12;
        int b = (year % 1000) % 12;
        int c = b / 4;
        int d = a + b + c;

        String doomsDay = dayweek[(index + d) % 7];
        System.out.println("Doomsday:" + doomsDay);

        int extraDays = findDaysToNextDoomsDay(day, month, year);
        int newIndex = (index + d - extraDays) % 7;
        System.out.println(dayweek[newIndex]);

    }

    public static int findDaysToNextDoomsDay(int day, int month, int year) {
        int days = 0;
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            String input = day + " " + month + " " + year;
            String next = "";
            if (month >= 1 && month <= 4) {
                next = "4 4 " + year;
                Date date1 = myFormat.parse(input);
                Date date2 = myFormat.parse(next);
                long diff = date2.getTime() - date1.getTime();
                days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            } else if (month >= 5 && month <= 8) {
                next = "8 8 " + year;
                Date date1 = myFormat.parse(input);
                Date date2 = myFormat.parse(next);
                long diff = date2.getTime() - date1.getTime();
                days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            } else {
                next = "12 12 " + year;
                Date date1 = myFormat.parse(input);
                Date date2 = myFormat.parse(next);
                long diff = date2.getTime() - date1.getTime();
                days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Day difference: " + days);
        }
        return days;
    }
}
