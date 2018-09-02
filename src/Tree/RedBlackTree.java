package Tree;

import common.RedBlackTreeNode;
import common.TreeNode;

/**
 * Author:  fankk
 * Date:    2018/8/31 15:22
 * Desc:   红黑树
 */
public class RedBlackTree {


      /**
        *@desc:  对红黑树调整，
        *@author:  fankk
        *@date:   2018/8/31 15:59
        *@param:
        *@return:
      */
    public void RBInsertFixup(RedBlackTreeNode tree, RedBlackTreeNode adjustNode){

        while(adjustNode.parent.color=="RED"){     //对红黑树的调整的条件

            //祖父节点
            RedBlackTreeNode grandFatherNode = adjustNode.parent.parent;
            RedBlackTreeNode fatherNode = adjustNode.parent;


            if(grandFatherNode.left==fatherNode) {  //父节点是祖父节点的左孩子
                RedBlackTreeNode   uncleNode=grandFatherNode.right;
                if(uncleNode.color=="RED"){
                  /*
                     1.把父节点，叔叔节点设置为黑色
                     2.把祖父节点 设置为红色
                     3.adjustNode设置为  祖父节点
                   */
                }else{
                    if(adjustNode==fatherNode.right){  //lr 左右旋转

                        adjustNode=fatherNode ;  // 3.adjustNode设置为  祖父节点
                        lRotate(fatherNode);     //祖父节点
                    }else {
                        fatherNode.color = "BLACK";
                        grandFatherNode.color = "RED";
                        rRotate(fatherNode);        //lRotate  父节点
                        adjustNode = fatherNode;    // 3.adjustNode设置为   父节点
                    }
                }

            }else{
                RedBlackTreeNode uncleNode=grandFatherNode.left;
                if(uncleNode.color=="RED"){
                  /*
                     1.把父节点，叔叔节点设置为黑色
                     2.把祖父节点 设置为红色
                     3.adjustNode设置为  祖父节点
                   */
                }else{
                    if(adjustNode==fatherNode.left){  //rl 右_左旋转
                        fatherNode.color="BLACK";
                        grandFatherNode.color="RED";
                        adjustNode=grandFatherNode ;  // 3.adjustNode设置为  祖父节点
                        rRotate(grandFatherNode);     //祖父节点
                    }
                     lRotate(fatherNode);        //lRotate  父节点
                     adjustNode =fatherNode;    // 3.adjustNode设置为   父节点
                }
            }




        }
    }


    /**
     *@desc:    红黑树的右旋
     *
     */
    public RedBlackTreeNode rRotate(RedBlackTreeNode node){
        RedBlackTreeNode leftNode =node.left;
         leftNode.parent =node.parent;

        node.left=leftNode.right;
        leftNode.right.parent=node;

        leftNode.right = node;
        node.parent=leftNode;
        return leftNode;
    }
    /**
     *@desc:    红黑树的左旋转，
     */
    public RedBlackTreeNode lRotate(RedBlackTreeNode node){
        RedBlackTreeNode rightNode =node.right;
        rightNode.parent=node.parent;

        node.right=rightNode.left;
        rightNode.left.parent=node;

        rightNode.left=node;
        node.parent=rightNode;

        return rightNode;
    }
}
