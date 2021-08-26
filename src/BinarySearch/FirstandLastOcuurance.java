package BinarySearch;

import java.util.*;

public class FirstandLastOcuurance {

    public static void main(String[] args)  {
        int n=9,x=7;
        long arr[]={5,4,2,9,7,7,7,12,7};

        System.out.println(find(arr,9,7));
        }

    static ArrayList<Long> find(long arr[], int n, int x)
    {
        int start=0,end=n-1;
        int resF=-1,resL=-1,mid;
        ArrayList<Long> a=new ArrayList<Long>();

        while(start<=end && start>=0 && end>=0)
        {
            mid=(start+end)/2;

            if(arr[mid]==x)
            {
                resF=mid;
                end=mid-1;
            }
            else if(arr[mid]>x)
                end=mid-1;
            else if(arr[mid]<x)
                start=mid+1;

        }
        a.add((long)resF);

        start=0;end=n-1;

        while(start<=end && start>=0 && end>=0)
        {
            mid=(start+end)/2;

            if(arr[mid]==x)
            {
                resL=mid;
                start=mid+1;
            }
            else if(arr[mid]>x)
                end=mid-1;
            else if(arr[mid]<x)
                start=mid+1;

        }
        a.add((long)resL);

        return a;
    }
}
