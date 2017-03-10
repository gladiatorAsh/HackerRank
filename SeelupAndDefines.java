/**

As every coder does, Seelup loves using defines in his code. 

For example, instead of writing pair<int,int> he writes pii. Here p is for pair, and i is for int which is first and second parameter. Seelup only defines pair's and doesn't use any type other than int. Note that first or/and second parameter can also be a pair. Please see the samples for better understanding.

The pair class couples together a pair of values, which may be of different types(int or a pair in this case.)

type can be defined as type = int | pair<type, type>
So, pair can be further expanded to a variety of expressions like:

pair<int,pair<int,int>>, pair<pair<int,int>,pair<int,int>>,     pair<int,pair<int,pair<int,int>>> and so on.
One day, Seelup's friend Bayro came and found only defined types. He knows which structure Seelup uses in his defines, so he wants to know original type. Please help him to do this, if the given defined type is not valid print .

Input Format

First and only line of input contains string , Seelup's defined type.

Constraints


Output Format

You should print original type of Seelup's define type.

Sample Input 0

pii
Sample Output 0

pair<int,int>

 */



 import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    String input = in .nextLine();

    char[] arr = input.toCharArray();
    int length = arr.length;

    if (arr[0] == 'i' || arr[length - 1] == 'p') {
      System.out.println("-1");
      return;
    }

    HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        int temp = map.get(arr[i]);
        map.put(arr[i], temp + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    if (map.get('i') - map.get('p') != 1) {
      System.out.println("-1");
      return;
    }

    StringBuilder str = new StringBuilder();
    Stack stack = new Stack();
    //Use a stack to store track of bracket insertions
    //Store operands as x

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 'p') {
        str.append("pair<");
        stack.push(">");
        stack.push("x");
        stack.push(",");
        stack.push("x");
      } 
      else {
        str.append("int");
      }

      while (!stack.empty() && stack.peek() != "x") {
        str.append(stack.pop());
      }
     
      if (!stack.empty()) {
        stack.pop();
      }
    }



    System.out.println(str.toString());

  }


}
