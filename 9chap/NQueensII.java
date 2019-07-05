public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return count;
        }
        search(n, new ArrayList<Integer>());
        return count;
    }

    private void search (int n, List<Integer> cols) {
        if (cols.size() == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            search(n, cols);
            cols.remove(cols.size() - 1);
        }
        return;
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
            if (i - row == cols.get(i) - col) {
                return false;
            }
        }
        return true;
    }
}
