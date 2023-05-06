package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {
    static ListNode head=null;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        while(q>0){
            String []str=br.readLine().split(" ");
            int pos;
            switch (str[0]){
                case "i":
                    pos=Integer.parseInt(str[1]);
                    int val=Integer.parseInt(str[2]);
                    insert_node(pos,val);
                    break;
                case "p":
                    print_ll();
                    break;
                case "d":
                    pos=Integer.parseInt(str[1]);
                    delete_node(pos);
            }
            q--;
        }
    }
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(position<=0)
            return;
        ListNode prev=null;
        ListNode A=head;
        while(A!=null && position>1){
            prev=A;
            A=A.next;
            position--;
        }
        if(position>1){
            return;
        }
        if(prev==null){
            head=new ListNode(value);
            head.next=A;
        }else{
            prev.next=new ListNode(value);
            prev.next.next=A;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position<=0)
            return;
        ListNode prev=null;
        ListNode A=head;
        while(A!=null && position>1){
            prev=A;
            A=A.next;
            position--;
        }
        if(A==null){
            return;
        }
        if(prev==null)
            head=A.next;
        else
            prev.next=A.next;
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode A=head;
        while(A!=null){
            System.out.print(A.val+" ");
            A=A.next;
        }
        System.out.println();
    }
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
