package graph;

import java.util.List;

public interface CycleDetect {
    boolean isCyclePresent(List<List<Integer>> adj, int v);
}
