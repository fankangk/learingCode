package newcoder.solve.linked.list;

import common.ListNode;

/**
 * Author:  fankk
 * Date:    2018/7/17 15:29
 * Desc:
 */
public class Plus {

     /*
     *@Desc: 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
     *       编写函数对这两个整数求和，并用链表形式返回结果。给定两个链表ListNode* A，ListNode* B，
     *@Author  fankk
     *@Date    2018/7/17
     */
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if(a==null||b==null){ return null;}
        int currentValue =0;
        int carryBit=0;
        ListNode curA =a;
        ListNode curB =b;

        ListNode head =new ListNode(0);
        ListNode ptr = head;
        while(curA!=null && curB !=null){
            currentValue=(curA.val+curB.val+carryBit)%10;
            carryBit =(curA.val+curB.val+carryBit)/10;
            curA=curA.next;
            curB =curB.next;
            ListNode cur =new ListNode(currentValue);
            ptr.next=cur;
            ptr=cur;
        }
        while(curA!=null){
            currentValue=(curA.val+carryBit)%10;
            carryBit =(curA.val+carryBit)/10;
            curA=curA.next;
            ListNode cur =new ListNode(currentValue);
            ptr.next=cur;
            ptr=cur;
        }
        while(curB!=null){
            currentValue=(curB.val+carryBit)%10;
            carryBit =(curB.val+carryBit)/10;
            curB=curB.next;
            ListNode cur =new ListNode(currentValue);
            ptr.next=cur;
            ptr=cur;
        }
        if(carryBit!=0){
            ListNode cur =new ListNode(carryBit);
            ptr.next=cur;
        }

        return head.next;
    }
}
