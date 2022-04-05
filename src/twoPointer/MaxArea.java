package twoPointer;

/**
 * You are given an integer array height of length n
 * Return the maximum amount of water a container can store.
 * O(N) using two pointers to get maxArea (max water)
 * You can greedily get max area by decrementing/incrementing left or right pointer => by removing the smaller height
 * as we need larger height to make larger area
 */

public class MaxArea {
    private static int get(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right])
                left += 1;
            else if (height[left] > height[right])
                right -= 1;
            else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
