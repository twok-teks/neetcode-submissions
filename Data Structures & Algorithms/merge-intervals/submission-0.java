class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        int currStart = intervals[0][0];
        ArrayList<int[]> results = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= minHeap.peek()){
                if(intervals[i][1] > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(intervals[i][1]);
                }
            } else {
                results.add(new int[]{currStart, minHeap.poll()});
                currStart = intervals[i][0];
                minHeap.add(intervals[i][1]);
            }
        }
        results.add(new int[]{currStart, minHeap.poll()});
        int[][] arrResult = results.toArray(new int[0][]);
        return arrResult;
    }
}
