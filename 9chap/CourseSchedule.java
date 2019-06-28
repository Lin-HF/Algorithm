public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] indegree = new int[numCourses];
        List<List<Integer>> neighbors = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            neighbors.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            neighbors.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }


        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int c : neighbors.get(course)) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    count++;
                    queue.offer(c);
                }
            }
        }

        return count == numCourses;
    }
}
