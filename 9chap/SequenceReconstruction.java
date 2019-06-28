public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        if (org == null || seqs == null) {
            return false;
        }
        int n = org.length;
        int[] indegree = new int[n + 1];
        List<List<Integer>> neighbors = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            neighbors.add(new ArrayList<>());
        }

        int count = 0;
        for (int i = 0; i < seqs.length; i++) {
            count += seqs[i].length;
            if (seqs[i].length >= 1 && (seqs[i][0] < 0 || seqs[i][0] > n)) {
                return false;
            }
            for (int j = 1; j < seqs[i].length; j++) {
                if (seqs[i][j] < 0 || seqs[i][j] > n) {
                    return false;
                }
                neighbors.get(seqs[i][j - 1]).add(seqs[i][j]);
                indegree[seqs[i][j]]++;
            }
        }

        if (count < n) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (org[index++] != num || queue.size() > 0) {
                return false;
            }
            for (Integer nb : neighbors.get(num)) {
                indegree[nb]--;
                if (indegree[nb] == 0) {
                    queue.offer(nb);
                }
            }
        }
        return index == n;
    }
}
