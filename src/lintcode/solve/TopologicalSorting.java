package lintcode.solve;

import common.DirectedGraphNode;

import java.util.*;

/**
 * @Auther: fankk
 * @Date: 2018/11/12 11:20
 * @Desc:
 */
public class TopologicalSorting {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        //表示节点的的入度的个数
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode directedGraphNode:graph){
            ArrayList<DirectedGraphNode>  neighborsNode =directedGraphNode.neighbors;
            if(neighborsNode==null||neighborsNode.size()==0){
                continue;
            }
            for(DirectedGraphNode enterNode:neighborsNode ) {
                if(map.containsKey(enterNode)){
                    map.put(enterNode,map.get(enterNode)+1);
                }else{
                    map.put(enterNode,1);
                }
            }
        }

        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        //找出入度为0的节点
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            if(node.neighbors==null||node.neighbors.size()==0){
                continue;
            }
            for (DirectedGraphNode var : node.neighbors) {
                map.put(var, map.get(var) - 1);
                if (map.get(var) == 0) {
                    q.add(var);
                    result.add(var);
                }
            }
        }
           return result;
    }
}
