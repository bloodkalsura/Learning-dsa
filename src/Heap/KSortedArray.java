package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KSortedArray {

    public static void main(String[] args) {
        int[] arr={6, 5, 3, 2, 8, 10, 9};
        int k=3;

        System.out.println("The sorted Array is : "+ksorted(arr,k,arr.length));
    }

    public static ArrayList<Integer> ksorted(int[] arr, int k, int n) {

        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        ArrayList<Integer> ans=new ArrayList<>();

        for(int x:arr){
            minHeap.add(x);
            if(minHeap.size()>k) ans.add(minHeap.poll());
        }

        while(minHeap.size()>0){
            ans.add(minHeap.poll());
        }

        return  ans;
    }
}
