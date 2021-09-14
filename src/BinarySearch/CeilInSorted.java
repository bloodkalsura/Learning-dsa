package BinarySearch;

public class CeilInSorted {

    public static void main(String[] args)
    {
        int [] ip={1, 2, 8, 10, 10, 12, 19,20};
        int key=11;

        System.out.println("Largest element ceil of "+key+" is "+solve(ip,key));

    }

    public static int solve(int[] arr,int key) {

        int n=arr.length;
        int start=0,end=n-1;
        int res=-1;

        while(start<end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==key)
                return key;

            if(arr[mid]>key)
            {
                res=arr[mid];
                end=mid-1;
            }
            if(arr[mid]<key)
            {
                start=mid+1;
            }
        }
        return res;
    }
}
