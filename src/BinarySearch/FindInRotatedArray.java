package BinarySearch;

import java.util.ArrayList;

public class FindInRotatedArray {

    public static void main(String[] args)
    {
        int [] ip={11,13,16,17,25,2,6,7};
        int n=17;

        System.out.println("Element is at Index "+solve(ip,n));

    }

    public static int solve(int[] arr,int n)
    {
        int N=arr.length;
        int index=-1,pivot=-1;
        int start=0,end=N-1;
        ArrayList<Integer> a2=new ArrayList<>();
        ArrayList<Integer> a1=new ArrayList<>();

        while(start<=end)
        {
            int mid=(start+end)/2;
            int next=arr[(mid+1)%N];
            int prev=arr[(mid+N-1)%N];

            if(arr[mid]<prev && arr[mid]<next)
                pivot=mid;

            if(arr[mid]>arr[start])
                start=mid+1;
            else
                end=mid-1;
        }

        for(int i=0;i<pivot;i++)
            a1.add(arr[i]);

        for(int i=pivot;i<N;i++)
            a2.add(arr[i]);

        Integer[] b1=new Integer[a1.size()];
        Integer[] b2=new Integer[a2.size()];

        a1.toArray(b1);
        a2.toArray(b2);

        int index1=binarySearch(b1,n);
        int index2=binarySearch(b2,n);

        if(index1==-1 && index2==-1)
            index=-1;
        else if(index1==-1)
            index=index2;
        else
            index=index1;

        return index;
    }

    public static int binarySearch(Integer[] arr,int n)
    {
        int start=0,end=arr.length-1;
        int index=-1;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==n)
                index=mid;

            if(arr[mid]>n)
                end=mid-1;
            else
                start=mid+1;
        }
        return index;
    }
}
