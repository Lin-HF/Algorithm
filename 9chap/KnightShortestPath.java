/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();

                for (int j = 0; j < dx.length; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                        continue;
                    }

                    if (grid[nx][ny]) {
                        continue;
                    }

                    if (nx == destination.x && ny == destination.y) {
                        return path;
                    }

                    queue.offer(new Point(nx, ny));
                    grid[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}
