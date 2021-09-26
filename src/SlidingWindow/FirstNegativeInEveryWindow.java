package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInEveryWindow {

    public static void main(String[] args) {

        int[] arr={12,-1,-7,8,-15,30,16,-28}; //-1 -1 -7 -15 -15 0 -28

        int n=arr.length;

        int k=2;

        solve(arr,n,k);
    }

    public static void solve(int[] arr,int n,int k)
    {
        /*
        We compare the element at i index if it has to be removed from the window
        we also remove it from the queue
         */
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        int i=0,j=0;

        while(j<n)
        {
            if(arr[j]<0)
                q.add(arr[j]);

            if(j-i+1<k)
                j++;
            else if(j-i+1==k)
            {
                int temp=-1;
                if(q.size()==0)
                    ans.add(0);
                else
                {
                    temp=q.peek();
                    ans.add(temp);
                }

                if(arr[i]==temp)
                    q.poll();

                i++;
                j++;
            }
        }

        System.out.println("The first negative in the Subarray is : "+ans);
    }
}
