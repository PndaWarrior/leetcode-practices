class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;

        if (total % 2 > 0) {
            return findKth(total/2+1, nums1, nums2, 0, 0);
        } else {
            return (findKth(total/2+1, nums1, nums2, 0, 0) + findKth(total/2, nums1, nums2, 0, 0)) /2.0;
        }

    }
    
    public static int findKth(int k, int[] nums1, int[] nums2, int startPoint1, int startPoint2) {
        if(startPoint1 >= nums1.length) {
            return nums2[startPoint2 + k - 1];
        }
        
        if(startPoint2 >= nums2.length) {
            return nums1[startPoint1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[startPoint1], nums2[startPoint2]);
        }
        
        int midIndex1 = startPoint1 + k/2 - 1;
        int midIndex2 = startPoint2 + k/2 - 1;
        
        int midValue1 = midIndex1 < nums1.length ? nums1[midIndex1] : Integer.MAX_VALUE;
        int midValue2 = midIndex2 < nums2.length ? nums2[midIndex2] : Integer.MAX_VALUE;
        
        if(midValue1 < midValue2) {
            return findKth(k-k/2, nums1, nums2, midIndex1 + 1, startPoint2 );
        } else {
            return findKth(k-k/2, nums1, nums2, startPoint1, midIndex2 + 1);
        }
    }
    
}