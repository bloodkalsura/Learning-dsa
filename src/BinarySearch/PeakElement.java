package BinarySearch;

public class PeakElement {

    public static void main(String[] args) {

        int[] arr={4,3,5,874,42,85,987,47};

        System.out.println("The peak element index is "+solve(arr));
    }

    public static int solve(int[] arr) {

        int start=0,end=arr.length-1;

        while (start<end)
        {
            int mid=start+(end-start)/2;

            if(mid!=0 || mid!=arr.length-1)
            {
                if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
                    return mid;

                else if(arr[mid+1]>arr[mid])
                    start=mid+1;
                else
                    end=mid-1;
            }

            if(mid==0)
            {
                if(arr[1]<arr[0])
                    return 0;
            }
            if(mid==arr.length-1)
            {
                if(arr[mid-1]<arr[mid])
                    return mid;
            }
        }

        return -1;
    }
}
