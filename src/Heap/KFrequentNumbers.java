package Heap;

import java.util.*;

class pair {
    int x;
    int y;

    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class KFrequentNumbers {

    public static void main(String[] args) {
        int[] arr={1,1,1,3,2,2,4,4};
        int k=3;

        System.out.println("The top "+k+" frequent numbers are "+solve(arr,k));
    }

    public static ArrayList<Integer> solve(int[]  arr, int k)
    {
        Map<Integer,Integer> mp=new HashMap<Integer,Integer>();

        for(int i=0;i<arr.length;i++)
        {
            if(mp.containsKey(arr[i]))
                mp.put(arr[i],mp.get(arr[i])+1);
            else
                mp.put(arr[i],1);
        }

        PriorityQueue<pair> pq=new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> e:mp.entrySet())
        {
            pair p =new pair(e.getKey(), e.getValue());
            pq.add(p);

            if(pq.size()>k)
                pq.poll();
        }

        ArrayList<Integer> ans=new ArrayList<>();

        while(!pq.isEmpty())
        {
            int a= (int) pq.peek().y;
            ans.add(a);
            pq.poll();
        }
        return ans;
    }
}
