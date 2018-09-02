package newcoder.solve.tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Author:  fankk
 * Date:    2018/7/23 10:50
 * Desc:
 */
public class Checker {

     /**
       *@desc:     检查一棵二叉树是否为二叉查找树。
       *@author:  fankk
       *@date:   2018/7/23 15:21
     */
     Stack<TreeNode> stack = new  Stack<TreeNode>();
    public boolean checkBST(TreeNode root) {
          //二叉树的中序遍历
          int lastValue= Integer.MIN_VALUE;
          int value = 0;
         if(root ==null) { return true;}
        stack.push(root);
        TreeNode currNode =root.left;
         while(!stack.isEmpty()||currNode!=null){
             if(currNode!=null){
                 stack.push(currNode);
                 currNode=currNode.left;
             }else{
                 TreeNode tempNode=stack.pop();
                 value= tempNode.val;
                 if(value<=lastValue){
                     return false;
                 }
                 lastValue=value;
                 currNode=tempNode.right;
             }

         }


//        if(root ==null) { return true;}
//
//        checkBST2(root.left,Integer.MIN_VALUE ,root.val);
//        checkBST2(root.right,root.val ,Integer.MAX_VALUE);
        return true;
    }



    public boolean checkBST2(TreeNode root,int min ,int max) {

        if(root==null){
            return true;
        }
        int val = root.val;
        if(val<min||val>max){
            return false;
        }

        return checkBST2(root.left,min,val)&&checkBST2(root.right,val,max);

       // checkBST2(root.left,)
    }

}
