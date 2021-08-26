package BinarySearch;

import java.util.*;

public class TimesASortedArrayRotated {

    public static void main(String[] args)
    {
        int [] ip={15, 18, 2, 3, 6, 12};

        int ans=solve(ip);

        System.out.println("Array is rotated "+ans);

    }

    public static int solve(int[] arr)
    {
        int n=arr.length;
        int s=-1,e=-1;
        int start=0,end=arr.length-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            int next=arr[(mid+1)%n];
            int prev=arr[(mid+n-1)%n];

            if(arr[mid]<next && arr[mid]<prev)
                return mid;

            if(arr[start]<arr[mid])
                start=mid+1;

            if(arr[mid]<arr[end])
                end=mid-1;
        }
        return -1;
    }
}