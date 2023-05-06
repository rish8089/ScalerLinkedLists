package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReorderList {
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
        ListNode head=reorderList(head1);
        print(head);
    }
    public static ListNode reorderList(ListNode A) {
        if(A==null || A.next==null)
            return A;
        ListNode mid=getMiddle(A);
        ListNode temp=mid.next;
        mid.next=null;
        ListNode B=reverse(temp);
        //now we need to merge these two linked lists in an alternative fashion
        int cnt=1;
        ListNode res=null;
        ListNode head=null;
        while(A!=null && B!=null){
            ListNode t;
            if(cnt%2!=0){
                t=A;
                A=A.next;
            }else{
                t=B;
                B=B.next;
            }
            if(res==null) {
                head=t;
                res = t;
            }
            else{
                res.next=t;
                res=res.next;
            }
            cnt++;
        }
        if(A!=null) {
            res.next = A;
        }
        if(B!=null) {
            res.next = B;
        }
        return head;
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

    private static ListNode reverse(ListNode A){
        ListNode h2=null, temp;
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
