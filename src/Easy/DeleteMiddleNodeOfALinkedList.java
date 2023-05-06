package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteMiddleNodeOfALinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ListNode head=null;
        ListNode tail=null;
        for(int i=1;i<=n;i++){
            int x=Integer.parseInt(br.readLine());
            if(head==null) {
                head = new ListNode(x);
                tail=head;
            }else{
                tail.next=new ListNode(x);
                tail=tail.next;
            }
        }
        print(solve2(head));
    }

    //using 3 variables
    public ListNode solve(ListNode A) {
        if(A==null || A.next==null)
            return null;
        ListNode slow=A;
        ListNode fast=A;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return A;
    }

    //using 2 variables
    public static ListNode solve2(ListNode A) {
        if(A==null || A.next==null)
            return null;
        ListNode fast=A;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            if(prev==null)
                prev=A;
            else
                prev=prev.next;
            fast=fast.next.next;
        }
        prev.next=prev.next.next;
        return A;
    }

    private static void print(ListNode A){
        while(A!=null){
            System.out.print(A.val + " ");
            A=A.next;
        }
        System.out.println();
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
