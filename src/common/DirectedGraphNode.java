package common;

import java.util.ArrayList;

/**
 * @Auther: fankk
 * @Date: 2018/9/18 13:30
 * @Desc:  有向图的定义
 */
public class DirectedGraphNode {

      public int label;
      public ArrayList<DirectedGraphNode> neighbors;
      public DirectedGraphNode(int x) {
          label = x;
         neighbors = new ArrayList<DirectedGraphNode>();
      }
}
