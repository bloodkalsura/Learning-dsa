package Heap;

import java.util.PriorityQueue;

public class MinimumCostOfRope {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        System.out.println("The minimum cost of the ropes is "+solve(arr));
    }

    public static int solve(int[] arr)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i:arr)
        {
            pq.add(i);
        }

        int cost=0;

        while(pq.size()>1)
        {
            int a=pq.poll();
            int b=pq.poll();

            int temp=a+b;
            cost+=temp;

            pq.add(temp);
        }

        return cost ;
    }
}
