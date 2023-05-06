package Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicList {
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
        System.out.println(solve(head1));
        print(head1);
    }
    public static int solve(ListNode A) {
        ListNode h1=null;
        int ans=0;
        while(A!=null){
            //checking for odd length palindrome centered around A
            ListNode h2=A.next;
            ListNode tmp=h1;
            int cnt=1;
            while(h1!=null && h2!=null){
                if(h1.val!=h2.val)
                    break;
                cnt+=2;
                h1=h1.next;
                h2=h2.next;
            }
            ans=Math.max(ans,cnt);

            //checking for even length palindrome centered around A
            if(A.next!=null){
                if(A.val==A.next.val){
                    h2=A.next.next;
                    h1=tmp;
                    cnt=2;
                    while(h1!=null && h2!=null){
                        if(h1.val!=h2.val)
                            break;
                        cnt+=2;
                        h1=h1.next;
                        h2=h2.next;
                    }
                }
                ans=Math.max(ans,cnt);
            }
            //restoring h1 back
            h1=tmp;
            //saving next
            ListNode next=A.next;
            //updating h1
            A.next=h1;
            h1=A;
            A=next;
        }
        reverse(h1);
        return ans;
    }

    private static void reverse(ListNode A){
       ListNode h2=null, temp;
        while(A!=null){
            temp=A;
            A=A.next;
            temp.next=h2;
            h2=temp;
        }
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
