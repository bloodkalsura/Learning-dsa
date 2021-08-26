package Stack;
import java.util.*;

public class MaximumAreaOfHistogramBinary
{
    public static void main(String[] args) {
        int[][] grid=   {{0,1,1,0},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,0,0}};
        int n=maxArea(grid,grid.length,grid[0].length);
        System.out.println("Maximum Area of Histogram is "+n);

    }

    public static int maxArea(int grid[][], int n, int m) {
        int[] a=new int[m];

        // for(int i=0;i<grid[0].length;i++)
        //     a[i]=grid[0][i];

        int maximum=0;//maximumAreaOfHist(a);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                    a[j]=0;
                else
                    a[j]++;
            }

            maximum=Math.max(maximum,maximumAreaOfHist(a));
        }

        return maximum;

    }

    public static int maximumAreaOfHist(int[] a)
    {
        int n=a.length;

        int[] nsl=nextSmallerLeft(a);
        int[] nsr=nextSmallerRight(a);

        // System.out.println(Arrays.toString(nsl));
        // System.out.println(Arrays.toString(nsr));

        int width=0;
        int area=0;
        int max=-1;

        for(int i=0;i<n;i++)
        {
            width=nsr[i]-nsl[i]-1;
            area=a[i]*width;
            max=Math.max(max,area);
        }

        return max;
    }

    public static int[] nextSmallerLeft(int[] a)
    {
        int n=a.length;
        int[] nsl=new int[n];
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty() && a[i]<=a[s.peek()])
                s.pop();

            if(s.isEmpty())
                nsl[i]=-1;
            else
                nsl[i]=s.peek();

            s.push(i);
        }
        return nsl;
    }

    public static int[] nextSmallerRight(int[] a)
    {
        int n=a.length;
        int[] nsr=new int[n];
        Stack<Integer> s=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && a[i]<=a[s.peek()])
                s.pop();

            if(s.isEmpty())
                nsr[i]=n;
            else
                nsr[i]=s.peek();

            s.push(i);
        }
        return nsr;
    }
}
