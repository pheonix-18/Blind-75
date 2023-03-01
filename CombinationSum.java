class Solution {
    List<List<Integer>> sol = new ArrayList<>();
    int[] candidates;
    int target;
    void combinationSumHelper(int i, int sum, List<Integer> currSol){
        if(sum > target)
            return;
        if(sum == target){
            System.out.println("Sum equals target");
            System.out.println("Add: " + currSol);
            sol.add(new ArrayList<>(currSol));
            return;
        }
        while(i < candidates.length){
            currSol.add(candidates[i]);
            sum += candidates[i];
            combinationSumHelper(i, sum, currSol);

            currSol.remove(currSol.size() - 1);
            sum -= candidates[i];
            i++;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        combinationSumHelper(0, 0 ,new ArrayList<Integer>());
        return sol;
    }
}
