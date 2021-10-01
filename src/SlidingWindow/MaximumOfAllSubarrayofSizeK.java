package SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumOfAllSubarrayofSizeK {

    public static void main(String[] args) {

        int[] arr={12,-1,-7,8,-15,30,16,-28}; //-1 -1 -7 -15 -15 0 -28

        int n=arr.length;

        int k=2;

        solve(arr,n,k);
    }

    public static void solve(int[] arr,int n,int k)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        int i=0,j=0;

        while(j<n)
        {
            pq.add(arr[j]);

            if(j-i+1<k)
                j++;
            else if(j-i+1==k)
            {
                int temp=pq.peek();
                ans.add(temp);

                if(temp==arr[i])
                    pq.poll();

                i++;
                j++;
            }
        }
        System.out.println("The maximum in all the subarray is : "+ans);
    }
}
