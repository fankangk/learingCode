package newcoder.solve.tree;

import common.TreeNode;

import java.util.ArrayList;

/**
 * Author:  fankk
 * Date:    2018/7/18 9:52
 * Desc:
 */
public class Balance {
    /**
      *@desc:   检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1
      *@author:  fankk
      *@date:   2018/7/18 10:05
      *@param:    TreeNode
      *@return:     boolean
     */
    public boolean isBalance(TreeNode root) {

     int m=   getDepth(root);

       if(m==-1) {
           return false;
       }
       return true;
    }

      /**
        *@desc:     求节点的深度
        *@author:  fankk
        *@date:   2018/7/18 10:17
        *@param:  TreeNode
        *@return: int
      */
    public int getDepth(TreeNode node) {
        if(node==null) {return 0;}
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        //判断平衡树，加的条件
        if(left==-1 ||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }


      /**
        *@desc:  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
       *         路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
       *         注：在返回值的list中，数组长度大的数组靠前
        *@author:  fankk
        *@date:    2018/7/18 10:49
        *@param:   TreeNode int
        *@return:  ArrayList
      */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        return null ;
    }
}
