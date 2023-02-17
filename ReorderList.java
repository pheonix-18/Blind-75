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
    public void reorderList(ListNode head) {
        Stack<ListNode> blocks = new Stack<ListNode>();
        ListNode curr = head;
        ListNode start = head;
        while(curr!=null){
                blocks.push(curr);
                curr = curr.next;
        }
        int n = blocks.size();
        while(start.next!=null && blocks.size()!=(n/2)+1){
            ListNode nextNode = start.next;
            ListNode top = blocks.pop();
            start.next = top;
            top.next = nextNode;
            start = nextNode;
            blocks.peek().next = null;
        }
    }
}
