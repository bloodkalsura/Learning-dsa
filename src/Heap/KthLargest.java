package Heap;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args)
    {
        int[] arr= {56,87,36,24,14,9,7};
        int k=3;

        System.out.println("The Kth Largest Element : "+findKthLargestElement(arr,k,arr.length));
    }

    private static int findKthLargestElement(int[] arr, int k, int size)
    {
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();

        minHeap.add(arr[0]);

        for(int i=1;i<size;i++)
        {
            minHeap.add(arr[i]);

            if(k<minHeap.size())
                minHeap.poll();
        }

        return minHeap.peek();
    }
}
