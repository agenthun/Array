package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/6.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        int[] result = {-1, -1};

        int left = 0;
        int right = nums.length - 1;

//        binarySearch(nums, 0, nums.length - 1, target, result);

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                result[0] = mid;
                result[1] = mid;

                int r1 = mid;
                while (r1 > left && nums[r1] == nums[r1 - 1]) {
                    r1--;
                    result[0] = r1;
                }

                int r2 = mid;
                while (r2 < right && nums[r2] == nums[r2 + 1]) {
                    r2++;
                    result[1] = r2;
                }
                return result;
            }
        }
        return result;
    }

    private void binarySearch(int[] nums, int left, int right, int target, int[] result) {
        if (right < left) return;

        if (nums[left] == nums[right] && nums[left] == target) {
            result[0] = left;
            result[1] = right;
            return;
        }

        int mid = (left + right) / 2;

        if (target < nums[mid]) {
            binarySearch(nums, left, mid - 1, target, result);
        } else if (target > nums[mid]) {
            binarySearch(nums, left + 1, right, target, result);
        } else {
            result[0] = mid;
            result[1] = mid;

            int t1 = mid;
            while (t1 > left && nums[t1] == nums[t1 - 1]) {
                t1--;
                result[0] = t1;
            }

            int t2 = mid;
            while (t2 < right && nums[t2] == nums[t2 + 1]) {
                t2++;
                result[1] = t2;
            }
            return;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int target = 8;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("target = " + target);
        int[] result = new SearchForARange().searchRange(a, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
