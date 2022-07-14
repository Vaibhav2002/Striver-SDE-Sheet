package greedy;

import java.util.Arrays;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1">Problem</a>
 **/
public class FractionalKnapsack {
    private static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, (a1, a2)->Double.compare(getValuePerWeight(a2), getValuePerWeight(a1)));
        double sum = 0;
        for(Item item:arr){
            double costPerWt = getValuePerWeight(item);
            sum += costPerWt * Math.min(item.weight, W);
            W -= Math.min(item.weight, W);
        }
        return sum;
    }

    private double getValuePerWeight(Item item) {
        return (double) item.value / (double) item.weight;
    }
}
