class UnionFind{
    int[] fathers;
    int count;
    UnionFind(int n) {
        fathers = new int[n];
        for (int i = 0; i < n; i++) {
            fathers[i] = i;
        }
    }

    void setCount(int count) {
        this.count = count;
    }
    int getCount() {
        return count;
    }
    int find(int x) {
        if (fathers[x] != x) {
            fathers[x] = find(fathers[x]);
        }
        return fathers[x];
    }
    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            fathers[rootA] = rootB;
            count--;
        }
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        int count = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1') {
                    count++;
                }
            }
        }
        uf.setCount(count);

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '0') {
                    continue;
                }
                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == '1') {
                        uf.union(x * n + y, nx * n + ny);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
