package Array;

public class FirstOccuranceInArray {

    public static void main(String[] args)
    {
        int[] arr = {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        System.out.println("The First index of 1 is "+solve(arr));
    }

    public static int solve(int[] arr)
    {
        int start=0,end=arr.length-1;
        int index=-1;

        while(start<end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==1)
            {
                index=mid;
                end=mid-1;
            }

            if(arr[mid]==0)
            {
                start=mid+1;
            }
        }
        return index;
    }
}
