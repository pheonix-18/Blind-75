class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int oC = 0; // overlappingCount
        Arrays.sort(intervals, (o1, o2)->Integer.compare(o1[0], o2[0]));
        int i = 1, j = intervals[0][1];
        while(i < intervals.length){
            if(intervals[i][0] < j){
                oC++;
                j = Math.min(j, intervals[i][1]);
            }
            else
                j = intervals[i][1];
            i++;
        }
        return oC;
    }
}
