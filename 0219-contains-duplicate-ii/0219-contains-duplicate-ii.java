

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }
        
        HashSet<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (window.contains(nums[i])) {
                return true;
            }
            
            
            window.add(nums[i]);
            
            
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}
