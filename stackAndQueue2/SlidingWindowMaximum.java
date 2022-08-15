package stackAndQueue2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">Problem</a>
 **/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length, index = 0;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.poll();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offer(i);

            if (i >= k - 1)
                ans[index++] = nums[dq.peek()];
        }
        return ans;
    }
}
