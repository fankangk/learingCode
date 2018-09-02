package newcoder.solve.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:  fankk
 * Date:    2018/7/20 9:31
 * Desc:
 */
public class EqualTargetPath {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> reList = new ArrayList<ArrayList<Integer>>();
        if(null==root){
            return reList;
        }
        ArrayList<Integer> pathList = new ArrayList<Integer>();  //当前路径

        Stack<TreeNode> stack = new  Stack<TreeNode>();
        stack.push(root);
        int sum =0;
        TreeNode curNode = root;  //当前节点
        TreeNode lastNode=null;  //保存上一个节点
        while(!stack.isEmpty()){
           if(null==curNode){
               TreeNode temp = stack.peek();
               if(temp.right!=null && temp.right!=lastNode){
                   lastNode =temp;
                   curNode=temp.right;
               }else{
                   lastNode=temp;
                   stack.pop();
                   if(pathList.size()>0){
                   pathList.remove(pathList.size()-1);
                   }
                   sum -=temp.val;

               }
           }else{
               stack.push(curNode);
               sum+=curNode.val;
               pathList.add(pathList.size(),curNode.val);      //添加到当前路径
               if(curNode.left==null && curNode.right==null && sum==target){
                   reList.add(new ArrayList(pathList));
               }
               lastNode=curNode;
               curNode=curNode.left;
           }

        }

        return reList;
    }

}
