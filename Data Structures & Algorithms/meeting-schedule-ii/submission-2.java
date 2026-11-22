/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;

        // 1. Sort intervals by start time: O(N log N)
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // 2. Min-Heap stores the END times of meetings currently occupying each room
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Put the first meeting's end time into the first room
        minHeap.add(intervals.get(0).end);

        // 3. Process remaining meetings: O(N log N) total
        for (int i = 1; i < intervals.size(); i++) {
            // If the earliest-ending room finishes at or before the new meeting starts, reuse it
            if (intervals.get(i).start >= minHeap.peek()) {
                minHeap.poll(); // Remove the old end time (room frees up)
            }

            // Add the new meeting's end time (either reusing the freed room or opening a new one)
            minHeap.add(intervals.get(i).end);
        }

        // The number of end times left in the heap equals the total rooms needed
        return minHeap.size();
    }
}
