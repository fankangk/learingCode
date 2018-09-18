package graph;

import common.DirectedGraphNode;

import java.util.*;

/**
 * @Auther: fankk
 * @Date: 2018/9/18 13:33
 * @Desc:  有向图
 */
public class DirectedGraph {



     /**
      * @desc:   给出一张有向图，设计一个算法判断两个点 s 与 t 之间是否存在路线。
      *          利用广度优先遍历
      * @date:   2018/9/18 13:36
      * @param:
      * @return:
      */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {

        if(s==t){
            return true;
        }
        //已遍历过的节点
        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        //广度优先遍历
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        visited.add(s);
        queue.add(s);
       while(!queue.isEmpty()){
           DirectedGraphNode node = queue.poll();
           for (int i = 0; i < node.neighbors.size(); i++) {
               DirectedGraphNode nextNode=node.neighbors.get(i);
               if (visited.contains(nextNode)) {
                   continue;
               }
               if(nextNode==t) {
                   return true;
               }
               visited.add(nextNode);
               queue.add(nextNode);
           }
       }
       return false;
    }





    /**
     * @desc:    有向图判环,请你判断一个 n 个点，m 条边的有向图是否存在环。
     *           参数为两个int数组，start[i]到end[i]有一条有向边
     * @date:   2018/9/18 14:22
     * @param:
     * @return:
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        //对于同一个数，可能在start里面出现多次
        if(start==null||start.length==0){
            return false;
        }

        HashMap<Integer,List> map =  new  HashMap<Integer,List>();
        HashSet<Integer> startVisted =  new HashSet<Integer>();
        for(int i=0;i<start.length;i++){
            if(start[i]==end[i]){
                return true;
            }

            if(startVisted.contains(end[i])){
                int key = end[i];
                List list = map.get(key);

                while(list!=null &&list.size()>0){

                    if(list.contains(start[i])){
                        return true;
                    }
                    List list1  = new ArrayList();
                    for(int index=0;index<list.size();index++){
                        if(map.containsKey(list.get(index))){
                            list1.addAll(map.get(list.get(index)));
                        }
                    }
                    list=list1;
                }

            }
           if(map.containsKey(start[i])){
               List list = map.get(start[i]);
               list.add(end[i]);
           }else{
                List list = new ArrayList();
                list.add(end[i]);
                map.put(start[i],list);
           }
           startVisted.add(start[i]);

        }
        return false;
    }



}
