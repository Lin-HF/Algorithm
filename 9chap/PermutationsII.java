public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }
    private void helper(int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> results) {
        if (tmp.size() == nums.length) {
            results.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            helper(nums, visited, tmp, results);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
        return;
    }

};
