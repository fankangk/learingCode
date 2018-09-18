package graph;

import common.UndirectedGraphNode;

import java.util.*;

/**
 * @Auther: fankk
 * @Date: 2018/9/18 14:00
 * @Desc:  无向图
 */
public class Graph {





     /**
      * @desc:   无向图中的最短路径
      *          给出一个undirected graph，其中每条边的长度为1，并从图中给出两个节点。
      *          我们需要找到给定两个节点之间最短路径的长度
      * @date:   2018/9/18 14:19
      * @param:  
      * @return: 
      */
    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
       int len=0;
       if(A==B){
           return len;
       }
        //类似二叉树的层次遍历中的标志位 ，路径长度1，2，3时区分
        UndirectedGraphNode flag = new UndirectedGraphNode(0);

        HashSet<UndirectedGraphNode> visted = new   HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        visted.add(A);
        queue.add(A);
        queue.add(flag);
        while(!queue.isEmpty()){

            UndirectedGraphNode node = queue.poll();
            if(node==flag){
                len++;
                queue.add(flag);
                continue;
            }
            for(int i=0;i<node.neighbors.size();i++){

                UndirectedGraphNode nextNode =  node.neighbors.get(i);
                if(visted.contains(nextNode)){
                    continue;
                }
                if(nextNode==B){
                   return len+1;
                }
                visted.add(nextNode);
                queue.add(nextNode);
            }
        }

      return -1;

    }



}
