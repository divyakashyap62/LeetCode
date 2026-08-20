class Solution {
    public void moveZeroes(int[] nums) {
        int newPos = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[newPos] = nums[i];
                newPos++;
            }
        }    
            while(newPos<nums.length){
            nums[newPos]=0;
            newPos++;
            }
        
    }
    
}