package L_3SUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DeadBlue on 2017/3/31.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        Solution solution = new Solution();
        List<List<Integer>> ret = new ArrayList<>();
        ret = solution.threeSum(nums);
        System.out.println("OK!");
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (len < 3) {
            return ret;
        }
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ret.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k + 1] == nums[k]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }

            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
            }


        }
        return ret;
    }
}