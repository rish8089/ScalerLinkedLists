package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortList {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n1=Integer.parseInt(br.readLine());
        ListNode head1=null;
        ListNode tail1=null;
        for(int i=1;i<=n1;i++){
            int x=Integer.parseInt(br.readLine());
            if(head1==null) {
                head1 = new ListNode(x);
                tail1=head1;
            }else{
                tail1.next=new ListNode(x);
                tail1=tail1.next;
            }
        }
        print(sortList(head1));
    }
    public static ListNode sortList(ListNode A) {
        if(A==null || A.next==null)
            return A;
        ListNode middle=getMiddle(A);
        ListNode temp=middle.next;
        middle.next=null;
        return mergeTwoLists(sortList(A),sortList(temp));
    }

    private static ListNode getMiddle(ListNode A){
        ListNode slow=A;
        ListNode fast=A.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeTwoLists(ListNode A,ListNode B) {
        ListNode head=null;
        ListNode p=null;
        while(A!=null && B!=null){
            ListNode temp;
            if(A.val<=B.val){
                temp=A;
                A=A.next;
            }else {
                temp = B;
                B=B.next;
            }
            if(head==null) {
                head=temp;
                p=head;
            }
            else{
                p.next=temp;
                p=p.next;
            }
        }
        if(A!=null) {
            if(head==null)
                head=A;
            else
                p.next=A;
        }
        if(B!=null){
            if(head==null)
                head=B;
            else
                p.next=B;
        }
        return head;
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
