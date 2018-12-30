/**
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */
 class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {

      public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            temp.next = curr.next;
            curr.next=temp;
            curr = curr.next.next;
        }

        curr = head;

        while (curr != null) {
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;

        RandomListNode newHead = curr.next;
        RandomListNode temp = newHead;

        while (temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }

        printNodes(newHead);

        return newHead;
    }

    public static void printNodes(RandomListNode head){
        
        while(head!=null){
            System.out.print(head.label+"random("+head.random.label+") -->");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        RandomListNode first=new RandomListNode(1);
        RandomListNode second=new RandomListNode(2);
        RandomListNode third=new RandomListNode(3);
        RandomListNode fourth=new RandomListNode(4);
        RandomListNode fifth=new RandomListNode(5);

        first.random=first;
        
        /*
        first.next=second;
        first.random=fourth;
        
        second.next=third;
        second.random=second;
        third.next=fourth;
        third.random=first;
        fourth.next=fifth;
        fourth.random=third;
        fifth.random=second;
        */
        printNodes(first);
        System.out.println("Copying list");
        copyRandomList(first);
        
    }
}
