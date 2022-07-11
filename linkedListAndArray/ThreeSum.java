package linkedListAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
* <a href="https://leetcode.com/problems/3sum/">Problem</a>
**/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            ans.addAll(getTriplets(nums, i, -1*nums[i]));
        }
        return ans;
    }

    private List<List<Integer>> getTriplets(int[] nums, int i, int target){
        List<List<Integer>> triplets = new ArrayList<>();
        int l = i+1, u = nums.length - 1;
        while(l<u){
            if(l+u == target){
                var list = List.of(nums[i], nums[l], nums[u]);
                triplets.add(list);
                while(nums[l] == list.get(1)) l++;
                while(nums[u] == list.get(2)) u--;
            }
            else if(l+u<target) l++;
            else u--;
        }
        return triplets;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        var ans = new ThreeSum().threeSum(nums);
        System.out.println(ans.toString());
    }
}
