package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartitionList {
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
        print(partition(head,B));
    }
    public static ListNode partition(ListNode A, int B) {
        ListNode h1=null,t1=null,h2=null,t2=null;
        while(A!=null){
            if(A.val<B){
                if(h1==null){
                    h1=A;
                    t1=h1;
                }else{
                    t1.next=A;
                    t1=t1.next;
                }
            }else{
                if(h2==null){
                    h2=A;
                    t2=A;
                }else{
                    t2.next=A;
                    t2=t2.next;
                }
            }
            A=A.next;
        }
        if(t2!=null)
            t2.next=null;
        if(t1!=null)
            t1.next=h2;
        return h1!=null?h1:h2;
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
