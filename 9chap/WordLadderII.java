public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        dict.add(end);
        bfs(start, dict, map, distance);
        dfs(end, start, new ArrayList<>(), map, distance, results);
        return results;
    }

    private void bfs(String start, Set<String> dict, Map<String, List<String>> map, Map<String, Integer> distance) {
        for (String word : dict) {
            map.put(word, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> nextWords = getNextWords(word, dict);
            for (String w : nextWords) {
                map.get(w).add(word);
                if (distance.containsKey(w)) {
                    continue;
                }
                distance.put(w, distance.get(word) + 1);
                queue.offer(w);
            }
        }
    }

    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String next = word.substring(0, i) + c + word.substring(i + 1);
                if (dict.contains(next)) {
                    nextWords.add(next);
                }
            }
        }
        return nextWords;
    }

    private void dfs(String crt, String start, List<String> path, Map<String, List<String>> map, Map<String, Integer> distance, List<List<String>> results) {
        path.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(path);
            results.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.get(crt) == distance.get(next) + 1) {
                    dfs(next, start, path, map, distance, results);
                }
            }
        }
        path.remove(path.size() - 1);
    }
}
