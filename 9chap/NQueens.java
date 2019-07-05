public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        search(n, new ArrayList<Integer>(), results);
        return results;
    }

    private void search (int n, List<Integer> cols, List<List<String>> results) {
        if (cols.size() == n) {
            results.add(draw(cols));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            search(n, cols, results);
            cols.remove(cols.size() - 1);
        }
        return;
    }
    private List<String> draw (List<Integer> cols) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            String str = "";
            for (int j = 0; j < cols.size(); j++) {
                str += j == cols.get(i) ? "Q" : ".";
            }
            result.add(str);
        }
        return result;
    }
    private boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (i + cols.get(i) == row + col) {
                return false;
            }
            if (i + col == row + cols.get(i)) {
                return false;
            }
        }
        return true;
    }
}
