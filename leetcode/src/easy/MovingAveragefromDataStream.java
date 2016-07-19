package easy;

import java.util.ArrayDeque;

/*
 * 346
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 * */
public class MovingAveragefromDataStream {

}

class MovingAverage {

    /** Initialize your data structure here. */
    private int size;
    private long sum;
    private ArrayDeque<Integer> queue;
    
    public MovingAverage(int size) {
        queue = new ArrayDeque<Integer>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
