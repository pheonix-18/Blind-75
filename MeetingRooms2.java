public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, (a, b) -> a.start - b.start);
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    pq.offer(intervals.get(0).end);
    int minMeetingRooms = 1;

    for(int i = 1; i < intervals.size(); i++){
        if(intervals.get(i).start < pq.peek()){
            minMeetingRooms++;
        }
        else{
            pq.poll();
        }
        pq.offer(intervals.get(i).end);
    }
    return minMeetingRooms;
    }
}
