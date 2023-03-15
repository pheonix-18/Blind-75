class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] mainInterval = new int[2];
        mainInterval = intervals[0];
        List<int[]> result = new ArrayList<int[]>();
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            if(mainInterval[1] < intervals[i][0]){
                result.add(mainInterval);
                mainInterval = intervals[i];
            }
            else{
                mainInterval[0] = Math.min(mainInterval[0], intervals[i][0]);
                mainInterval[1] = Math.max(mainInterval[1], intervals[i][1]);
            }
        }

        if(mainInterval != null)
            result.add(mainInterval);
        
        return result.stream().toArray(int [][]::new);

    }
}
