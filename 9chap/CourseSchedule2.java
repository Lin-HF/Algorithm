public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

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
        int[] result = new int[numCourses];
        int index = 0;
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                count++;
                result[index++] = i;
            }
        }


        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int c : neighbors.get(course)) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    count++;
                    result[index++] = c;
                    queue.offer(c);
                }
            }
        }
        if (index == numCourses) {
            return result;
        }
        return new int[0];
    }
}
