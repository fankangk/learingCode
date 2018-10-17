package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/10/15 15:22
 * @Desc:   全排列   给定一个数字列表，返回其所有可能的排列。
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        return null;
    }



    private void dfs(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }


}
