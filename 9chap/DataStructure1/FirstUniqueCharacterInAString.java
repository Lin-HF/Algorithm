public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        int[] map = new int[256];
        for (char c : str.toCharArray()) {
            map[c]++;
        }

        for (char c : str.toCharArray()) {
            if (map[c] == 1) {
                return c;
            }
        }
        return 'a';
    }
}
