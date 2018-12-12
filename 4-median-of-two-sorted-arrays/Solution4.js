/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {

    var total = nums1.length + nums2.length;

    if(total % 2 > 0) {
        return findKth(Math.floor(total/2)+1, nums1, nums2, 0, 0)
    } else {
        return (findKth(Math.floor(total/2)+1, nums1, nums2, 0, 0) + findKth(Math.floor(total/2), nums1, nums2, 0,0))/2
    }

};


function findKth(k, nums1, nums2, s1, s2) {
    if (s1 >= nums1.length) {
        return nums2[s2 + k - 1];
    }
    if (s2 >= nums2.length) {
        return nums1[s1 + k - 1];
    }
    if ( k == 1) {
        return Math.min(nums1[s1], nums2[s2]);
    }

    var halfOfK = Math.floor(k/2)

    var m1 = s1 + halfOfK - 1;
    var m2 = s2 + halfOfK - 1;

    var mid1 = (m1<nums1.length) ? nums1[m1] : Number.MAX_VALUE;
    var mid2 = (m2<nums2.length) ? nums2[m2] : Number.MAX_VALUE;

    if(mid1<mid2) {
        return findKth(k-halfOfK, nums1, nums2, m1 + 1, s2);
    } else {
        return findKth(k-halfOfK, nums1, nums2, s1, m2 + 1);
    }

};
