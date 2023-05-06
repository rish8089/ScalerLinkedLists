package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KReverseLinkedList {
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
        int k=Integer.parseInt(br.readLine());
        print(reverseList2(head,k));
    }

    //iterative, Space Complexity : O(1)
    public static ListNode reverseList(ListNode A, int B) {
        ListNode newHead=null;
        ListNode prev=null;
        while(A!=null && A.next!=null){
            ListNode ret=reverseFirstK(A,B);
            if(newHead==null)
                newHead=ret;
            if(prev!=null)
                prev.next=ret;
            prev=A;
            A=A.next;
        }
        return newHead;
    }
    private static ListNode reverseFirstK(ListNode A, int k){
        if(A==null || k<=1)
            return A;
        ListNode currHead=null, newHead=null, initialHead=A;
        while(A!=null && k>0){
            newHead=A;
            A=A.next;
            newHead.next=currHead;
            currHead=newHead;
            k--;
        }
        initialHead.next=A;
        return currHead;
    }
    //recursive, Space complexity : O(n/k)
    public static ListNode reverseList2(ListNode A, int B) {
        if(A==null)
            return null;
        ListNode ret=reverseFirstK(A,B);
        A.next=reverseList2(A.next,B);
        return ret;
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
