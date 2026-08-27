class Solution {
    public int rob(int[] nums) {
        int fprev=0;
        int sprev=0;

        int max=Integer.MIN_VALUE;

        for(int n : nums){
            max=Math.max(fprev,n+sprev);
            sprev=fprev;
            fprev=max;
        }
        return max;
    }
}
