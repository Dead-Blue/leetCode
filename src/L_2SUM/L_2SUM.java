package L_2SUM;

import java.util.HashMap;

/**
 * Created by DeadBlue on 2017/3/31.
 */
public class L_2SUM {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testCase = {2, 7, 11, 15};
        int[] ret = solution.twoSum(testCase, 9);
        System.out.println(ret[0] + " " + ret[1]);
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = numbers.length;
        int[] ret = new int[2];
        for (int i = 0; i < len; i++) {
            map.put(numbers[i], i + 1);
        }
        for (int i = 0; i < len; i++) {
            int next = target - numbers[i];
            if (map.containsKey(next)) {
                ret[0] = i + 1;
                ret[1] = map.get(next);
                break;
            }
        }
        return ret;
    }
}
