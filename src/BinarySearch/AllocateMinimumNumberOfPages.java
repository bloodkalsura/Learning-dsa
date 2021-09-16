package BinarySearch;

public class AllocateMinimumNumberOfPages {

    public static void main(String[] args)
    {
        //Number of pages in books
        int arr[] = {12, 34, 67, 90};

        int m = 2; //No. of students

        System.out.println("Minimum number of pages = " +
                findPages(arr, arr.length, m));
    }

    public static int findPages(int[] arr,int n,int m)
    {
        if(n<m)
            return -1;

        int start=0;
        int end=0;

        for(int i:arr)
            end+=i;

        int ans=-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(isvalid(arr,n,m,mid)==true)
            {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;

    }

    public static boolean isvalid(int[] arr,int n,int m,int max)
    {
        int student=1;
        int sum=0;

        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum>max)
            {
                student++;
                sum=arr[i];
            }

            if(student>m)
                return false;
        }

        return true;
    }
}
