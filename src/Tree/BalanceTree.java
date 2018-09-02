package Tree;

import common.TreeNode;

/**
 * Author:  fankk
 * Date:    2018/8/15 11:21
 * Desc:
 */
public class BalanceTree {
 /*
 四种旋转情况 ：
       LL :被破坏平衡节点的左子树的左子树造成的 右旋转

       LR :被破坏平衡节点的左子树的右子树造成的 左——右旋转
          左旋转之后变为了LL

       LL :被破坏平衡节点的右子树的右子树造成的 左旋转

       Rl :被破坏平衡节点的右子树的左子树造成的  右——左旋转
  */


     /**
       *@desc:   平衡二叉树右旋转
      *           原根节点的左孩子，变为左孩子的右孩子   （1）
      *           原根节点的左孩子的孩子变为根节点       （2）
      *           新根节点的右孩子变为原根节点          （3）
       *@author:  fankk
       *@date:   2018/8/31 11:06
       *@param: node 被破坏的平衡点的
       *@return:
     */

    public TreeNode rRotate(TreeNode node){

        TreeNode leftNode =node.left;
        node.left=leftNode.right;
        leftNode.right=node;
        return leftNode;
    }

    
    
    
      /**
        *@desc:    平衡二叉树左旋转，
       *
        *@author:  fankk
        *@date:   2018/8/31
        *@param:  
        *@return: 
      */
    public TreeNode lRotate(TreeNode node){

        TreeNode leftNode =node.left;
        node.left=leftNode.right;
        leftNode.right=node;
        return leftNode;
    }
}
