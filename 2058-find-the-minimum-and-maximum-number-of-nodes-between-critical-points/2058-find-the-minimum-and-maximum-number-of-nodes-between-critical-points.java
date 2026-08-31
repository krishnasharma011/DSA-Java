/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans={-1,-1};
        if(head.next.next==null) return ans;
        List<Integer> li=new ArrayList<>();
        int idx=0;
        ListNode a=head;
        ListNode b=a.next;
        ListNode c=b.next;
        while(c!=null){
            if((b.val>a.val && b.val>c.val) || (b.val<a.val && b.val<c.val)){
                li.add(idx);
            }
            idx++;
            a=a.next;
            b=b.next;
            c=c.next;
        }
        if(li.size()<=1) return ans;
        int min=li.get(li.size()-1)-li.get(li.size()-2);
        for(int i=1;i<li.size()-1;i++){
            min=Math.min(li.get(i)-li.get(i-1),min);
        }
        ans[0]=min;
        ans[1]=li.get(li.size()-1)-li.get(0);
        return ans;
    }
}