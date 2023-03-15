class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newList = new LinkedList<>();
       
        // Add Non-Overlapping Intervals
        int i = 0;
        for(int []interval: intervals){
            if(interval[1] < newInterval[0]){
                newList.add(interval);
                i++;
            }
            else
                break;
        }
        // Merge new Interval with overlapping intervals
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        newList.add(newInterval);
        // Add rest of the intervals
        while(i < intervals.length)
            newList.add(intervals[i++]);

        return newList.stream().toArray(int[][]::new);
    }

    boolean isOverlap(int[] interval, int[] newInterval){
        if(interval[0] > newInterval[1] || interval[1] < newInterval[0])
            return false;
        return true;
    }
}
