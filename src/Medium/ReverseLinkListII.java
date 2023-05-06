package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLinkListII {
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
        String []BC=br.readLine().split(" ");
        int B=Integer.parseInt(BC[0]);
        int C=Integer.parseInt(BC[1]);
        head=reverseBetween(head,B,C);
        print(head);
    }
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if(B>=C || A==null)
            return A;
        int pos=1;
        ListNode prev=null;
        ListNode head=A;
        // to reach B-1th node
        while(pos<B){
            prev=A;
            A=A.next;
            pos++;
        }
        ListNode ret=reverseTillGivenPosition(A,C-B+1);
        if(prev==null)
            return ret;
        else{
            prev.next=ret;
            return head;
        }
    }

    private static ListNode reverseTillGivenPosition(ListNode A, int C){
        if(A==null)
            return A;
        ListNode h2=null,temp;
        ListNode head=A;
        while(A!=null && C>0){
            temp=A;
            A=A.next;
            temp.next=h2;
            h2=temp;
            C--;
        }
        head.next=A;
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
