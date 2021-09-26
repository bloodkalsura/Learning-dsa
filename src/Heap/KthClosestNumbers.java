package Heap;

import java.lang.reflect.Array;
import java.util.*;

class Pair
{
    int first;
    int second;

    public void setValues(int first,int second) {
        this.first = first;
        this.second=second;
    }
}

public class KthClosestNumbers {

    public static void main(String[] args)
    {
        int[] arr={5,6,7,8,9};

        int k=3,x=7;

        System.out.println("The closest Numbers are : "+solve(arr,k,x));
    }

    public static ArrayList<Integer> solve(int[] arr,int k,int x)
    {
        ArrayList<Pair> temp=new ArrayList<>();
        Pair[] p=new Pair[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            p[i]=new Pair();
            p[i].setValues(Math.abs(arr[i]-x),arr[i]);
            temp.add(p[i]);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.first-b.first;
            }
        });

        for(Pair i:p)
        {
            pq.add(i);

            if(pq.size()>k)
                pq.poll();
        }

        ArrayList<Integer> ans= new ArrayList<>();

        while(!pq.isEmpty())
        {
            Pair a=pq.poll();
            ans.add(a.second);
            pq.poll();
        }

        return ans;
    }
}
