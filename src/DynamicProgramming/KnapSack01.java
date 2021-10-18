package DynamicProgramming;

import java.util.Arrays;

public class KnapSack01 {

    static int[][] dp=new int[102][102];

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        for(int[] a:dp)
            Arrays.fill(a,-1);

        System.out.println("Maximum Profit possible is : "+knapSack(W, wt, val, n));
    }

    public static int knapSack(int w,int[] wt,int[] val,int n)
    {
        if(n==0 || w==0)
            return 0;

        if(dp[n][w]!=-1)
            return dp[n][w];

        if(wt[n-1]<=w) {
            return dp[n][w] = Math.max(knapSack(w, wt, val, n - 1), val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1));
        }
        else
        {
            return dp[n][w]=knapSack(w,wt,val,n-1);
        }

    }
}
