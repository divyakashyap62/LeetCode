class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If the element to the right is larger, the peak lies on the right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // If the current element is larger or equal to its right neighbor, 
            // a peak exists on the left side (including mid itself)
            else {
                right = mid;
            }
        }
        
        // Left and right converge to the peak element index
        return left;
    }
}
