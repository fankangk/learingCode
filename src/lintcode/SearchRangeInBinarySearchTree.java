package lintcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: fankk
 * @Date: 2018/10/15 14:19
 * @Desc:  二叉查找树中搜索区间
 *        给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。
 *        即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
 */
public class SearchRangeInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;
        SearchRangeInBinarySearchTree s = new   SearchRangeInBinarySearchTree();
        List<Integer> re= s.searchRange(node1,1,1);
        System.out.println(re.toString());
    }
     /**
      * @desc:     1 .中序遍历
      * @date:   2018/10/15 14:37
      * @param:
      * @return:
      */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {

        //找到大于且最接近k1的TreeNode
        List<Integer> list = new ArrayList<Integer>();
        if(root==null){
           return  list;
        }

        Stack<TreeNode> stack = new  Stack<TreeNode>();
        stack.push(root);
        TreeNode node=root.left;
        while(node!=null && node.val>=k1){
            stack.push(node);
            node=node.left;
        }
        while(!stack.isEmpty()){

            TreeNode  popNode = stack.pop();
            if(popNode.val>=k1 && popNode.val<=k2){
                list.add(popNode.val);
            }

              node =popNode.right;
              while(node!=null){
                stack.push(node);
                node=node.left;
             }
        }
        return  list;
    }
}
