package newcoder.solve.linked.list;

import common.ListNode;

/**
 * Author:  fankk
 * Date:    2018/7/18 9:03
 * Desc:
 */
public class Palindrome {

       /*
       *@Desc:   检查链表是否为回文。
       *@Author  fankk
       *@Date    2018/7/18
       */
    public boolean isPalindrome(ListNode pHead) {

        /*
        1 .单链表变为双链表 ,由于ListNode 是单链表需要重新写
        2. 保持原链表不变  ，新建一个反转链表
         */
        ListNode preNode=null;
        int count=0;

        ListNode goNode=pHead;
        //反转链表
        while(goNode!=null){
            ListNode newCode = new ListNode(goNode.val);
            newCode.next =preNode;
            preNode=goNode;
            goNode = goNode.next;
            count++;
        }
        int number = (count+1)/2;
        //比较原链表与反转链表之后的值
        while(count>=number){
            if(preNode.val!=pHead.val){
                return false;
            }
            preNode=preNode.next;
            pHead=pHead.next;
            count--;
        }

       return  true;
    }
}
