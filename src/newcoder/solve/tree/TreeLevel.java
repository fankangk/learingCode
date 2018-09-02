package newcoder.solve.tree;

import common.ListNode;
import common.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:  fankk
 * Date:    2018/7/23 9:25
 * Desc:
 */
public class TreeLevel {


     // Queue<TreeNode> queue  = new LinkedList<TreeNode>();
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    public static void main(String[] args){
        TreeLevel t = new TreeLevel();
        TreeNode root = new TreeNode (1);
        TreeNode left = new TreeNode (2);
        TreeNode right = new TreeNode (3);
        root.left=left;
        root.right=right;
        t.getTreeLevel(root,1);
    }
     /**
       *@desc:   对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
                给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，
                 代表该深度上所有结点的值，请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
       *@author:  fankk
       *@date:   2018/7/23 9:26
     */
    public ListNode getTreeLevel(TreeNode root, int dep) {
        ListNode reListNode = new ListNode(0);
        int depth=1;

        TreeNode flagTreeNode = new TreeNode(0);
       if(root==null){
           return reListNode.next;
       }
        queue.add(root) ;
        queue.add(flagTreeNode);

       while(!queue.isEmpty()){
           if(depth==dep){
               break;
           }
           TreeNode node =  queue.poll();
           if(node==flagTreeNode){
               depth++;
               queue.add(flagTreeNode);
           }else{
               if(node.left!=null){queue.add(node.left);}
               if(node.right!=null){queue.add(node.right);}
           }

       }
        ListNode currListNode=reListNode;
        while(!queue.isEmpty()){
          TreeNode node =  queue.poll();
          if(node==flagTreeNode){break;}
          else{
              ListNode listNode = new ListNode(node.val);
              currListNode.next=listNode;
              currListNode=listNode;
          }

      }
       return reListNode.next;
    }
}
