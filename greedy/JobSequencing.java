package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#">Problem</a>
 **/

class DisjointSet {
    int[] parent;

    DisjointSet(int n) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
    }

    int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    void union(int u, int v) {
        parent[v] = u;
    }

}

public class JobSequencing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        System.out.println(Arrays.toString(new JobSequencing().JobScheduling(jobs, n)));
    }

    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a1, a2) -> Integer.compare(a2.profit, a1.profit));
        int maxDeadline = getMaxDeadline(arr);
        DisjointSet set = new DisjointSet(maxDeadline);
        int count = 0, sum = 0;
        for (Job j : arr) {
            int emptySlot = set.find(j.deadline);
            if (emptySlot > 0) {
                set.union(emptySlot - 1, emptySlot);
                count++;
                sum += j.profit;
            }
        }
        return new int[]{count, sum};
    }

    int getMaxDeadline(Job[] arr) {
        int max = 0;
        for (Job j : arr) max = Math.max(j.deadline, max);
        return max;
    }

    private static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
