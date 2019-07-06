public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> queueHelp = new LinkedList<>();
    public void push(int x) {
        // write your code here
        queue.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        while (queue.size() != 1) {
            queueHelp.offer(queue.poll());
        }

        queue.poll();
        swapQueue();
    }

    private void swapQueue() {
        while (!queueHelp.isEmpty()) {
            queue.offer(queueHelp.poll());
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (queue.size() != 1) {
            queueHelp.offer(queue.poll());
        }

        int item = queue.poll();
        queueHelp.offer(item);
        swapQueue();
        return item;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue.isEmpty();
    }
}
