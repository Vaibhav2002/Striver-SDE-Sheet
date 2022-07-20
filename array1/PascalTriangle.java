package array1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        if (numRows == 1) return ans;
        ans.add(List.of(1, 1));
        if (numRows == 2) return ans;
        dfs(2, numRows, ans);
        return ans;
    }

    private void dfs(int row, int n, List<List<Integer>> ans) {
        if (row >= n) return;
        ans.add(new ArrayList<>());
        for (int i = 0; i <= row; i++) {
            int sum = 0;
            if (i != 0) sum += ans.get(row - 1).get(i - 1);
            if (i != row) sum += ans.get(row - 1).get(i);
            ans.get(row).add(sum);
        }
        dfs(row + 1, n, ans);
    }


}
