package lintcode;

import java.util.*;

/**
 * @Auther: fankk
 * @Date: 2018/10/18 13:46
 * @Desc:  给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 */
public class MajorityElementII {

    class Node{
        int value;
        int count;
    }
    public static void main(String[] args){
        MajorityElementII m =new MajorityElementII();
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(1);
        nums.add(4);
        nums.add(1);
        nums.add(1);
        nums.add(4);
     int re=   m.majorityNumber(nums);
        System.out.println(re);
    }
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     *  每次去除三个不同的数组
     */

    public int majorityNumber(List<Integer> nums) {
       int len =nums.size();
       Node[] node = new Node[3];
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
     for(int i=0;i<len;i++){
      int count=  map.getOrDefault(nums.get(i),0);
      map.put(nums.get(i),count+1);

      if(map.size()==3){
          Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
          while(it.hasNext()){
              Map.Entry<Integer, Integer> entry = it.next();
              int key = entry.getKey();
              int value=entry.getValue();
              if(--value==0){
                  it.remove();
              }else{
                  map.put(key,value);
              }
          }

          }

     }
     for (Map.Entry<Integer, Integer> entry:map.entrySet()){
         int key = entry.getKey();
         int count=0;
         for(int i=0;i<len;i++){
             if(nums.get(i)==key){
                 count++;
             }
         }
         if(count*3>len){
             return key;
         }
     }
     return Integer.MIN_VALUE;
    }
}
