package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesFromSortedList {
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
        head=deleteDuplicates(head);
        print(head);
    }
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode res=null;
        ListNode head=A;
        while(A!=null){
            if(res==null)
                res=A;
            else {
                res.next = A;
                res=res.next;
            }
            while(A.next!=null && A.val==A.next.val){
                A=A.next;
            }
            A=A.next;
        }
        if(res!=null)
            res.next=null;
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
