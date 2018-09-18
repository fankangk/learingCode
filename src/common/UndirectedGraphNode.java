package common;

import java.util.ArrayList;

/**
 * @Auther: fankk
 * @Date: 2018/9/18 13:56
 * @Desc:  无向图的定义
 */
public class UndirectedGraphNode {


    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
