public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        if (A == null || B == null) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        int[] map = new int[256];
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            map[c]++;
        }

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            map[c]--;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
