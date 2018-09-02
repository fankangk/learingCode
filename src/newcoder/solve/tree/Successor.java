package newcoder.solve.tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Author:  fankk
 * Date:    2018/7/24 9:49
 * Desc:
 */
public class Successor {


     /**
       *@desc:     寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
       *@author:  fankk
       *@date:   2018/7/24 9:50
     */
    public int findSucc(TreeNode root, int p) {

        Stack<TreeNode> stack = new  Stack<TreeNode>();
        int findFlag =0;
        if(root ==null) { return -1;}
        TreeNode currNode =root;
        while(!stack.isEmpty()||currNode!=null){
            if(currNode!=null){
                stack.push(currNode);
                currNode=currNode.left;
            }else{
                TreeNode tempNode=stack.pop();

                if(findFlag==1){
                    return tempNode.val;
                }

                if(tempNode.val==p) {
                    findFlag=1;
                }
                currNode=tempNode.right;
            }

        }
        return -1;
    }
}
