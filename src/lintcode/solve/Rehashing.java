package lintcode.solve;

import common.ListNode;

/**
 * @Auther: fankk
 * @Date: 2018/11/12 14:48
 * @Desc: 重哈希
            哈希表容量的大小在一开始是不确定的。如果哈希表存储的元素太多（如超过容量的十分之一），
            我们应该将哈希表容量扩大一倍，并将所有的哈希值重新安排。
 */
public class Rehashing {


    public ListNode[] rehashing(ListNode[] hashTable) {

        if(hashTable==null){
            return hashTable;
        }
        int  size = hashTable.length;
        ListNode[] newTable = new  ListNode[size*2];
        for(int i=0;i<size;i++){
            ListNode node=hashTable[i];
            while(node!=null){
                int value=(node.val%newTable.length+newTable.length)%(newTable.length);
                ListNode var1=newTable[value];
                if(var1==null){
                    newTable[value]=new ListNode(node.val);
                    node=node.next;
                    continue;
                }
                while(var1.next!=null){
                    var1=var1.next;
                }
                var1.next=new ListNode(node.val);
                node=node.next;
            }
        }
        return newTable;
    }
}
