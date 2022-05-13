package twoPointer;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */

public class MergeSortedArray {
    private static int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int mergedArraySize = n1 + n2;
        int ans[] = new int[mergedArraySize];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {
            ans[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < n1)
            ans[k++] = nums1[i++];
        while (j < n2)
            ans[k++] = nums2[j++];

        for (int arr : ans)
            System.out.println(arr);
        return ans;
    }


}

