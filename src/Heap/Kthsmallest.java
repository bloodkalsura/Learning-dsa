package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kthsmallest {

    public static void main(String[] args) {
        int[] arr= {56,87,36,24,14,9,7};
        int k=3;

        System.out.println("The Kth Smallest Element : "+findKthSmallestElement(arr,k,arr.length));
    }

    private static int findKthSmallestElement(int[] arr, int k, int size) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
