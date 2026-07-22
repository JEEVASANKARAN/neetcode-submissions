class Solution {
    public int trap(int[] height) {
        int i=0;
        int water=0;
        int leftMax=0;
        int rightMax=0;
        int j=height.length-1;
        while(i<j){
            if(height[i]<height[j]){
            if(leftMax<height[i]){
                leftMax=height[i];
            }
            water+=leftMax-height[i];
            i++;
        }else{
            if(rightMax<height[j]){
                rightMax=height[j];
            }
            water+=rightMax-height[j];
            j--;
        }
        }
        return water;
    }
}
