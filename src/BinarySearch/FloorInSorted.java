package BinarySearch;

public class FloorInSorted {

    public static void main(String[] args)
    {
        int [] ip={1, 2, 8, 10, 10, 12, 19};
        int key=5;

        System.out.println("Largest element floor of "+key+" is "+solve(ip,key));

    }

    public static int solve(int[] arr,int key) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int max=0;

        while(start<end)
        {
            int mid=(start+end)/2;

            //System.out.println(arr[mid]);
            if(arr[mid]==key)
                return key;

            //{1, 2, 8, 10, 10, 12, 19}

            if(arr[mid]>key)
            {
                end=mid-1;
            }
            if(arr[mid]<key) {
                start=mid+1;
                max=arr[mid];
            }
        }
        return max;
    }
}
