public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (str == null) {
            return results;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper(chars, new boolean[chars.length], "", results);
        return results;
    }

    private void helper(char[] chars, boolean[] visited, String tmp, List<String> results) {
        if (tmp.length() == chars.length) {
            results.add(new String(tmp));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
                continue;
            }
            tmp += chars[i];
            visited[i] = true;
            helper(chars, visited, tmp, results);
            visited[i] = false;
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return;
    }
}
