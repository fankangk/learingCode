package lintcode.solve;

import common.ListNode;
import common.TreeNode;

/**
 * @Auther: fankk
 * @Date: 2018/11/5 08:51
 * @Desc:  给出一个所有元素以升序排序的单链表，
 *        将它转换成一棵高度平衡的二分查找树给出一个所有元素以升序排序的单链表，
 *       将它转换成一棵高度平衡的二分查找树
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args){
        ConvertSortedListToBinarySearchTree c =new ConvertSortedListToBinarySearchTree();

        ListNode node =new ListNode(-1);
        ListNode node1 =new ListNode(0);
        ListNode node2 =new ListNode(1);
        ListNode node3=new ListNode(3);

        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        c.sortedListToBST(node);
    }

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }


        ListNode  leftEndnode= getRootListNode(head);
        ListNode  rootNode=leftEndnode.next;
        ListNode rightStartnode=rootNode.next;
        leftEndnode.next=null;
        rootNode.next=null;

        TreeNode root =   new TreeNode(rootNode.val);
        root.left = sortedListToBST(head);
        if (rightStartnode!=null) {
            root.right = sortedListToBST(rightStartnode);
        }
        return root;

    }


    //
    public ListNode  getRootListNode(ListNode listNode ){
        int count=0;
        ListNode node=listNode;
        while(node!=null){
            count++;
            node=node.next;
        }
        node=listNode;
        int index=1;
        while(index<count/2){
            node=node.next;
            index++;
        }
       return node;
    }
}
