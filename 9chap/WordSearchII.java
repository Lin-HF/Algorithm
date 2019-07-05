class TrieNode {
    Map<Character, TrieNode> children;
    String word;
    public TrieNode() {
        children = new HashMap<>();
        word = null;
    }
}

class TrieTree {
    TrieNode root;
    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.word = word;
    }
}

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> results = new ArrayList<>();
        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, tree.root, results);
            }
        }
        return results;
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    private void search(char[][] board, int x, int y, TrieNode root, List<String> results) {
        char c = board[x][y];
        if (!root.children.containsKey(c)) {
            return;
        }

        TrieNode node = root.children.get(c);
        if (node.word != null) {
            if (!results.contains(node.word)) {
                results.add(node.word);
            }
        }

        board[x][y] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            search(board, nx, ny, node, results);
        }
        board[x][y] = c;
    }
}
