/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        List<UndirectedGraphNode> nodes = getAllNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        for (UndirectedGraphNode n : map.keySet()) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private List<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        //set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            set.add(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                //set.add(neighbor);
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
