package lintcode.solve;

import common.ListNode;

/**
 * @Auther: fankk
 * @Date: 2018/11/8 10:00
 * @Desc:
 */
public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode head) {
       if(head==null||head.next==null){
           return head;
       }
        ListNode virHead = new ListNode(0);
        virHead.next=head;
        ListNode lastNode= virHead;
        ListNode curNode= head;
        ListNode nextNode= head.next;
        while(nextNode!=null){

            if(curNode.val==nextNode.val){
                while(nextNode!=null && curNode.val==nextNode.val){
                    nextNode=nextNode.next;
                }
                lastNode.next=nextNode;
            }else{
                lastNode=curNode;
            }
            curNode=nextNode;
            if(nextNode!=null) {
                nextNode = nextNode.next;
            }


        }
    return virHead;
    }
}
