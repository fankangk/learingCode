package lintcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: fankk
 * @Date: 2018/10/15 08:55
 * @Desc: 二叉树的序列化和反序列化
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;

        node3.left=node4;
        node3.right=node5;
        SerializeAndDeserializeBinaryTree s= new SerializeAndDeserializeBinaryTree();
        String serialize=s.serialize(node1);
        System.out.println(serialize);
        TreeNode root= s.deserialize(serialize);
        String re=s.serialize(root);
        System.out.println(re);
    }


      /**
       * @desc:    序列化 二叉树BFS ,空树用#, 每层的化分时！
       * @date:   2018/10/15 8:59
       * @param:
       * @return:
       */
    public String serialize(TreeNode root) {

        ArrayList<String> reList = new   ArrayList<String>();
        if(root==null){
            return reList.toString().replace("[","{").replace("]","}");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            int countNull=0;
            for(int i=0;i<size;i++){
                TreeNode node=   queue.poll();
                if(node==null){
                    countNull=countNull+2;
                    reList.add("#");
                    queue.add(null);
                    queue.add(null);
                }else{
                    reList.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                    if(node.left==null){countNull++;}
                    if(node.right==null){countNull++;}
                }

            }
            if(countNull==size*2){
                break;
            }

        }
//        int temp =reList.size()-1;
//        while(reList.get(temp)=="#"){
//            reList.remove(temp--);
//        }

      return reList.toString().replace("[","{").replace("]","}").replaceAll(" ","");

    }

    public TreeNode deserialize(String data) {
       if(data.equals("{}")){
           return null;
       }
        Queue<TreeNode> queue = new LinkedList<>();
       String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int i=1;
      while(!queue.isEmpty()){
           TreeNode parentNode =queue.poll();
           if(parentNode==null){
               queue.add(null);
               queue.add(null);
               i=i+2;
               continue;
           }
           if(i>=vals.length){
               break;
           }
           TreeNode leftNode;
            if(!vals[i].equals("#")){
                leftNode = new TreeNode(Integer.parseInt(vals[i]));
            }else{
                leftNode =null;
            }
          queue.add(leftNode);
            parentNode.left=leftNode;
            i++;
          if(i>=vals.length){
              break;
          }

          TreeNode rightNode;
          if(!vals[i].equals("#")){
              rightNode = new TreeNode(Integer.parseInt(vals[i]));
          }else{
              rightNode =null;
          }
          queue.add(rightNode);
          parentNode.right=rightNode;
          i++;
       }
       return root;
    }
}
