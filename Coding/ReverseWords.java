/*
  Stacks are a particularly clever way of reversing anything as it follows LIFO.
  We just need to store words if they are to be reversed.
  If characters need to be reversed, that is even simpler. We wouldn't need the StringBuilder object.
*/

public static String reverseWords(char[] message){
    private Deque<String> stack =new ArrayDeque<String>();
    StringBuilder str=new StringBuilder();
    for(int i=0;i<message.length;i++){
        if(message[i]!=' '){
            str.append(message[i]);
        }
        else{
            stack.push(str.toString());
            str.setLength(0);
        }
    }
    StringBuilder res=new StringBuilder();
    while(!stk.isEmpty()){
        res.append(stack.pop()).append(" ");
    }

    return res.toString();
}
