package Stack;

import java.io.*;
import java.util.*;
import java.lang.*;

// } Driver Code Ends

class TrappingRainWater{

    public static void main (String[] args) throws IOException {
            int n = 6;
            int arr[] = {3,0,0,2,0,4};

            //calling trappingWater() function
            System.out.println(trappingWater(arr, n));
        }

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) {

        int[] mxl=new int[n];
        int[] mxr=new int[n];
        int[] vol=new int[n];

        mxl[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]<mxl[i-1])
                mxl[i]=mxl[i-1];
            else
                mxl[i]=arr[i];
        }

        mxr[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]<mxr[i+1])
                mxr[i]=mxr[i+1];
            else
                mxr[i]=arr[i];
        }

        for(int i=0;i<n;i++)
        {
            vol[i]=Math.min(mxr[i],mxl[i])-arr[i];
        }

        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=vol[i];
        }

        return ans;

    }
}



