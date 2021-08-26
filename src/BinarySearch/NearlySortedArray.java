package BinarySearch;

public class NearlySortedArray {

    public static void main(String[] args)
    {
        int [] ip={3, 2, 10, 4, 40};
        int key=4;

        System.out.println("Element is at Index "+solve(ip,key));

    }

    public static int solve(int[] arr,int key)
    {
        int n=arr.length;
        int start=0,end=n-1;
        int index=-1;

        while(start<=end)
        {
            int mid=(start+(end-start))/2;

            if(start>=0 &&end>=0)
            {
                if(arr[mid]==key)
                {
                    index=mid;
                    break;
                }else if(arr[mid+1]==key)
                {
                    index=mid+1;
                    break;
                }else if(arr[mid-1]==key) {
                    index = mid - 1;
                    break;
                }
            }

            if(arr[mid]>key)
                end=mid-2;

            if(arr[mid]<key)
                start=mid+2;

        }
        return index;
    }
}
