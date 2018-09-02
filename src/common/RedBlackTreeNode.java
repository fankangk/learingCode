package common;

/**
 * Author:  fankk
 * Date:    2018/8/31 15:42
 * Desc:
 */
public class RedBlackTreeNode {

    public int val = 0;
    public RedBlackTreeNode left = null;
    public RedBlackTreeNode right = null;
    public RedBlackTreeNode parent=null;
    public String  color;
}

enum COLOR
{
    BLACK, RED;
};