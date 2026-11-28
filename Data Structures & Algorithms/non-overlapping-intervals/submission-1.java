class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int[] currStart = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < currStart[1]){
                res++;
            } else {
                currStart = intervals[i];
            }
        }
        return res;
    }
}
