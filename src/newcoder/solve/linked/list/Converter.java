package newcoder.solve.linked.list;

import common.ListNode;
import common.TreeNode;

/**
 * Author:  fankk
 * Date:    2018/7/18 9:44
 * Desc:
 */
public class Converter {


  /*
  *@Desc:有一个类似结点的数据结构TreeNode，包含了val属性和指向其它结点的指针。
  * 其可以用来表示二叉查找树(其中left指针表示左儿子，right指针表示右儿子)。
  * 请编写一个方法，将二叉查找树转换为一个链表，其中二叉查找树的数据结构用TreeNode实现
  * 链表的数据结构用ListNode实现。给定二叉查找树的根结点指针root
  *@Author  fankk
  *@Date    2018/7/18
  */
    ListNode node= new ListNode(-1);
    ListNode head =node;
    public ListNode treeToList(TreeNode root) {
        if(root!=null){
            treeToList(root.left);
            node.next=new ListNode(root.val);
            node=node.next;
            treeToList(root.right);
         }
       return head.next;
    }
}
