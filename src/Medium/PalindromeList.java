package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeList {
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
        System.out.println(lPalin(head1)==1?"Palindrome":"Not Palindrome");
        print(head1);
    }
    public static int lPalin(ListNode A) {
        ListNode mid=getMiddle(A);
        ListNode h2=mid.next;
        mid.next=null;
        h2=reverse(h2);
        ListNode temp=h2;
        boolean flag=true;
        while(h2!=null){
            if(A.val!=h2.val) {
                flag=false;
                break;
            }
            A=A.next;
            h2=h2.next;
        }
        mid.next=reverse(temp);
        return flag?1:0;
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
