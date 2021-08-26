package Stack;

import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumAreaOfHistogram{


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            long n = Long.parseLong(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int)n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            System.out.println(new Solution().getMaxArea(arr, n));
        }
    }
}



// } Driver Code Ends



class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n)
    {
        Stack<Integer> s=new Stack<>();
        int N=(int)n;
        long[] nsl=new long[hist.length];
        long[] nsr=new long[hist.length];
        long[] wid=new long[hist.length];
        long[] ans=new long[hist.length];

        for(int i=N-1;i>=0;i--)
        {
            while(!s.isEmpty() && hist[i]<=hist[s.peek()])
                s.pop();

            if(s.isEmpty())
                nsr[i]=N;
            else
                nsr[i]=s.peek();

            s.push(i);
        }

        s.clear();

        for(int i=0;i<N;i++)
        {
            while(!s.isEmpty() && hist[i]<=hist[s.peek()])
                s.pop();

            if(s.isEmpty())
                nsl[i]=-1;
            else
                nsl[i]=s.peek();

            s.push(i);
        }

        // System.out.println(Arrays.toString(nsr));
        // System.out.println(Arrays.toString(nsl));

        long max=0;

        for(int i=0;i<N;i++)
        {
            wid[i]=nsr[i]-nsl[i]-1;
            ans[i]=hist[i]*wid[i];

            max=Math.max(max,ans[i]);
        }

        return max;
    }

}


