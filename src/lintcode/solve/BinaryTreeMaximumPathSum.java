package lintcode.solve;

import common.TreeNode;

/**
 * @Auther: fankk
 * @Date: 2018/11/2 17:10
 * @Desc:  给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（
 *         路径和为两个节点之间所在路径上的节点权值之和）
 */
public class BinaryTreeMaximumPathSum {

    class ReturnType{
       public  int rootSum;
       public int singalPathSum;

    }
    private int maxValue=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        ReturnType re=pathSum(root);
        return maxValue;
    }
    public ReturnType pathSum(TreeNode root) {
        // write your code here
        ReturnType re= new ReturnType();
        if(root  ==null){
            return re;
        }
        ReturnType left=pathSum(root.left);
        ReturnType right=pathSum(root.right);
        int  leftPath=Math.max(left.singalPathSum,0);
        int  rightPath=Math.max(right.singalPathSum,0);
        int sum =rightPath+ leftPath+root.val;
         int signalPath= Math.max(rightPath,leftPath)+root.val;
        re.rootSum=sum;
        re.singalPathSum=signalPath;
        maxValue=Math.max(sum,maxValue);
        return re;

    }
}
