public class MovingAverage {
    /*
    * @param size: An integer
    */
    Queue<Integer> queue;
    int size;
    double sum;
    public MovingAverage(int size) {
        // do intialization if necessary
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        sum += val;
        queue.offer(val);
        if (queue.size() > size) {
            sum -= queue.poll();
        }

        return sum / queue.size();
    }
}
