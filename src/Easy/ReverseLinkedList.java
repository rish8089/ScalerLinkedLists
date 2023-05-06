package Easy;

import Medium.ReverseLinkListII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLinkedList {
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
        head=reverseList(head);
        print(head);
    }
    public static ListNode reverseList(ListNode A) {
        ListNode h2=null,temp;
        while(A!=null){
            temp=A;
            A=A.next;
            temp.next=h2;
            h2=temp;
        }
        return h2;
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
