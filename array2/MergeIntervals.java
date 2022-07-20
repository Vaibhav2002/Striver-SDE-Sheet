package array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">Problem</a>
 **/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        var ans = new ArrayList<int[]>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] >= start && i[0] <= end) end = Math.max(i[1], end);
            else {
                ans.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new int[]{start, end});
        int[][] a = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) a[i] = ans.get(i);
        return a;
    }
}
