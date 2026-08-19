class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        
        
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        
        int low = maxWeight;
        int high = totalWeight;
        int result = high;
        
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canShip(weights, days, mid)) {
                result = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        
        return result;
    }
    
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysNeeded++; 
                currentLoad = 0; 
            }
            currentLoad += weight;
        }
        
        return daysNeeded <= days;
    }
}
