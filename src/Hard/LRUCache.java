package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;
    private HashMap<Integer,ListNode> mp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        LRUCache obj=new LRUCache(2);
        while(q>0){
            String []str=br.readLine().split(" ");
            int key;
            switch(str[0]){
                case "g":
                    key=Integer.parseInt(str[1]);
                    System.out.println(obj.get(key));
                    break;
                case "s":
                    key=Integer.parseInt(str[1]);
                    int value=Integer.parseInt(str[2]);
                    obj.set(key,value);
                    break;
            }
            q--;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        mp=new HashMap<>();
    }

    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;
        ListNode nd=mp.get(key);
        shift(nd);
        return nd.val;
    }

    public void set(int key, int value) {
        if(mp.containsKey(key)){
            ListNode nd=mp.get(key);
            nd.val=value;
            shift(nd);
        }else{
            if(size==capacity){
                delete();
            }
            insert(key,value);
        }
    }

    private void shift(ListNode nd){
        if(nd.prev==null)
            return;
        nd.prev.next=nd.next;
        //checking if nd is tail
        if(nd.next==null)
            tail=nd.prev;
        else
            nd.next.prev=nd.prev;
        nd.next=head;
        head.prev=nd;
        nd.prev=null;
        head=nd;
    }

    private void delete(){
        if(tail==null)
            return;
        mp.remove(tail.key);
        if(tail.prev==null){
            head=null;
            tail=null;
        }else{
            tail.prev.next=null;
            tail=tail.prev;
        }
        size--;
    }

    private void insert(int key, int val){
        if(head==null){
            head=new ListNode(key, val);
            tail=head;
        }else{
            ListNode nd=new ListNode(key, val);
            nd.next=head;
            head.prev=nd;
            head=nd;
        }
        size++;
        mp.put(key,head);
    }

    static class ListNode {
        public int val;
        public int key;
        public ListNode next;
        public ListNode prev;
        ListNode(int key, int value) { this.key=key; next = null; prev=null; this.val=value;}
    }
}
