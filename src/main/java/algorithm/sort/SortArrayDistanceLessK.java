package algorithm.sort;

import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    static void sortedArrDistanceLessK(int[] arr, int k) {
        // 默认小根堆（优先级队列）
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        int i = 0;
        for (; index < Math.min(arr.length, k); i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
