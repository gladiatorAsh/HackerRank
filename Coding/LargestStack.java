
/*
  You can optimize for either push,pop or you can optimize for finding largest.
  The following implementation is for optimization of the largest element in the stack
  It uses another stack to store all max Elements.
*/

import java.util.*;

public static class MaxStack{
    private Stack<Integer> stack=new Stack<Integer>();
    private Stack<Integer> maxStack=new Stack<Integer>();
  

    public int pop(){
        int item=stack.pop();
        if(item==maxStack.peek()){
            maxStack.pop();
        }
        return item;
    }

    public void push(int item){
        if(maxStack.isEmpty()||item>=maxStack.peek()){
            maxStack.push(item);
        }

        stack.push(item);
    }

    public int getMax(){
        
            return maxStack.peek();
        
    }

}
