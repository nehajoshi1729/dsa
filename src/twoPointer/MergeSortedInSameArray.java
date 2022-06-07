package twoPointer;

/**
 * merge two sorted arrays nums1 with m digits and nums2 with n digits
 * len(nums1) = m + n
 * merge arrays into nums1
 */

public class MergeSortedInSameArray {

    private static void merge(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            System.out.print(k);

            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }


        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }


    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        merge(nums1, nums2, m, n);
    }
}
