package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class FlattenALinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        ListNode head=null, tail=null;
        while(q>0){
            String []str=br.readLine().split(" ");
            int val;
            switch(str[0]){
                case "r":
                    val=Integer.parseInt(str[1]);
                    if(head==null){
                        head=new ListNode(val);
                        tail=head;
                    }else{
                        tail.right=new ListNode(val);
                        tail=tail.right;
                    }
                    break;
                case "d":
                    int pos=Integer.parseInt(str[1]);
                    val=Integer.parseInt(str[2]);
                    ListNode p=head;
                    while(p!=null && pos>1){
                        p=p.right;
                        pos--;
                    }
                    if(p!=null){
                        while(p.down!=null){
                            p=p.down;
                        }
                        p.down=new ListNode(val);
                    }else{
                        System.out.println("Invalid position");
                    }
            }
            q--;
        }
        print(flatten(head));
    }
    static ListNode flatten(ListNode root) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((nd1,nd2)->Integer.compare(nd1.val, nd2.val));
        ListNode res=null;
        ListNode head=null;
        while(root!=null){
            pq.add(root);
            root=root.right;
        }
        while(!pq.isEmpty()){
            ListNode nd=pq.poll();
            if(res==null){
                head=nd;
                res=nd;
            }else{
                res.down=nd;
                res=res.down;
            }
            if(nd.down!=null)
                pq.add(nd.down);
            res.right=null;
        }
        return head;
    }
    static class ListNode {
        public int val;
        public ListNode right,down;
        ListNode(int x) { val = x; right = null;down=null; }
    }
    private static void print(ListNode A){
        while(A!=null){
            System.out.print(A.val + " ");
            A=A.down;
        }
        System.out.println();
    }
}
