public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null){
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        helper(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> results) {
        if (tmp.size() == nums.length) {
            results.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            tmp.add(nums[i]);
            visited[i] = true;
            helper(nums, visited, tmp, results);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
        return;
    }
}
