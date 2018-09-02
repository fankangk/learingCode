package newcoder.solve.linked.list;

import common.ListNode;

/**
 * Author:  fankk
 * Date:    2018/7/17 14:19
 * Desc:
 */
public class Partition {

     /*
     *@Desc: 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前给定一个链表的头指针
     *       ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变
     *@Author  fankk
     *@Date    2018/7/17
     */
    public ListNode partition(ListNode pHead, int x) {

        ListNode lessHeadNode = new ListNode(0);
        ListNode moreHeadNode=new ListNode(0);;
        ListNode currentNode = pHead;

        ListNode lessCurrentNode = lessHeadNode;
        ListNode moreCurrentNode = moreHeadNode;
        while(currentNode!=null){
           if(currentNode.val<x){

               lessCurrentNode.next =currentNode;
               lessCurrentNode=currentNode;

           }else{
               moreCurrentNode.next =currentNode;
               moreCurrentNode=currentNode;
           }
            currentNode=currentNode.next;
        }
        moreCurrentNode.next =null;
        lessCurrentNode.next=moreHeadNode.next;
       return lessHeadNode.next;
    }

}
