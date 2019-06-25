import java.util.*;
class Point{
  int x;
  int y;
  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }
}
class Solution {
    public int numIsland(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int result = 0;
    for (int x = 0; x < grid.length; x++) {
      for (int y = 0; y < grid[0].length; y++) {
        if (grid[x][y] == '1'){
          result++;
          mark(grid, x ,y);
        }
      }
    }
    return result;
}

private void mark(char[][] grid, int x, int y) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x, y));
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    while (!queue.isEmpty()) {
      Point p = queue.poll();
      for (int i = 0; i < dx.length; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];
        if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
          continue;
        }
        if (grid[nx][ny] == '1') {
          queue.offer(new Point(nx, ny));
          grid[nx][ny] = '0';
        }
      }
    }
  }
}
