public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        helper(digits, 0, "", results);
        return results;
    }

    private void helper(String digits, int index, String tmp, List<String> results) {
        if (index == digits.length()) {
            results.add(new String(tmp));
            return;
        }

        char c = digits.charAt(index);
        for (char cha : letters[c - '0'].toCharArray()) {
            tmp += cha;
            helper(digits, index + 1, tmp, results);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return;
    }
}
