public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        if (pattern == null || str == null) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(pattern, str, map, set);
    }

    private boolean helper(String pattern, String str, Map<Character, String> map, Set<String> set) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char c = pattern.charAt(0);

        if (map.containsKey(c)) {
            if (!str.startsWith(map.get(c))) {
                return false;
            }
            return helper(pattern.substring(1),
                          str.substring(map.get(c).length()),
                          map,
                          set);
        }

        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (set.contains(word)) {
                continue;
            }

            set.add(word);
            map.put(c, word);
            if (helper(pattern.substring(1),
                       str.substring(word.length()),
                       map,
                       set)) {
                return true;
            }
            set.remove(word);
            map.remove(c);
        }
        return false;
    }
}
