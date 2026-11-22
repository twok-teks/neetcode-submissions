class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        boolean duplicate = false;
        for(int i = 0; i < nums.length; i++){
            if(numSet.size() == 0){
                numSet.add(nums[i]);
                continue;
            }
            if(numSet.contains(nums[i])){
                return true;
            } else {
                numSet.add(nums[i]);
            }
        }
        return duplicate;
    }
}