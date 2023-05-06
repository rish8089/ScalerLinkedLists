package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListCycle {
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
        tail1.next=tail1;
        ListNode res=detectCycle(head1);
        if(res==null)
            System.out.println("No cycle detected");
        else
            System.out.println(res.val);
    }
    public static ListNode detectCycle(ListNode a) {
        if(a==null)
            return null;
        ListNode slow=a;
        ListNode fast=a;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                break;
        }
        if(fast!=slow)
            return null;
        slow=a;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
