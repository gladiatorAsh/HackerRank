/**

Torque's teacher wants to punish him. So she gave Torque a positive long integer  and told him that it is the product of any three sides of a rectangle. Now, Torque needs to find and print all possible values of the  side in increasing order. Can you help Torque to accomplish this task ?

Input Format

A single line containing a positive long integer  (the product of any three sides of a rectangle).

Constraints

Output Format

A single line containing all possible values in increasing order. The values should be space-separated.

Sample Input 0

36
Sample Output 0

1 4 9 36

 */


 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long nsqrt=(long)Math.sqrt(n);
        ArrayList<Long> set=new ArrayList<Long>();
        for(long i=nsqrt;i>0;i--){
            if(n%(i*i)==0){
                //System.out.println(n/(i*i)+" ");
                set.add(n/(i*i));
                //i=i/2;
            }
        }
        
        //List sortedList = new ArrayList(set);
        //Collections.sort(sortedList);

        for(Object i:set){
            System.out.print(i+" ");
        }
        
    }
}
