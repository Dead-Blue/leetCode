package L_SearchForARange;

/**
 * Created by DeadBlue on 2017/4/7.
 */

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 2};
        Solution solution = new Solution();
        int[] ret = solution.searchRange(nums, 2);
        System.out.println(ret[0] + "," + ret[1]);
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] ret = new int[2];
        boolean flag = true;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ret[0] = mid;
                high = mid - 1;
                flag = false;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        if (flag) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        low = ret[0];
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ret[1] = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return ret;
    }
}