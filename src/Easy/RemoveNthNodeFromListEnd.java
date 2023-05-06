package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveNthNodeFromListEnd {
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
        int B=Integer.parseInt(br.readLine());
        head=removeNthFromEnd(head,B);
        print(head);
    }
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null)
            return null;
        ListNode head=A;
        while(A!=null && B>0){
            A=A.next;
            B--;
        }
        ListNode prev=null;
        while(A!=null){
            if(prev==null)
                prev=head;
            else
                prev=prev.next;
            A=A.next;
        }
        if(prev==null)
            return head.next;
        else{
            prev.next=prev.next.next;
            return head;
        }
    }
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    private static void print(ListNode A){
        while(A!=null){
            System.out.print(A.val + " ");
            A=A.next;
        }
        System.out.println();
    }
}
