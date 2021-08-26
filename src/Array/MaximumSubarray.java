package Array;

import java.util.ArrayList;

public class MaximumSubarray {

    static ArrayList<Integer> suarr=new ArrayList<>();
    static ArrayList<Integer> a=new ArrayList<>();

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};

        int ans=solve(nums);
        System.out.print(a);
        System.out.print(" The maximum sum of a Subarray is "+ans);
    }

    public static int solve(int[] arr) {
        int csum=arr[0];
        int msum=arr[0];
        suarr.add(arr[0]);

        for(int i=1;i<arr.length;i++)
        {
            csum=csum+arr[i];
            suarr.add(arr[i]);
            //{-2,1,-3,4,-1,2,1,-5,4}
            if(arr[i]>csum)
            {
                suarr.clear();
                suarr.add(arr[i]);
                csum=arr[i];
            }

            if(msum<csum)
            {
                msum=csum;
                a.clear();
                a.addAll(suarr);
            }

        }
        return msum;
    }

}